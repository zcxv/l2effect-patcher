/*
 * Copyright (c) 2015 acmi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package acmi.l2.clientmod.unreal.classloader;

import acmi.l2.clientmod.io.*;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.core.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.Class;
import java.lang.Object;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Entry properties:
 * <p>
 * if (entry.getObjectClass() == null) {
 * UClass uClass = new UClass(buffer, entry, this);
 * uClass.readProperties();
 * return uClass.getProperties();
 * }
 * if (getFlags(entry.getObjectFlags()).contains(HasStack)) {
 * getCompactInt(buffer);
 * getCompactInt(buffer);
 * buffer.position(buffer.position() + 12);
 * getCompactInt(buffer);
 * }
 */
public class PropertiesUtil {
    private UnrealClassLoader unrealClassLoader;

    PropertiesUtil(UnrealClassLoader unrealClassLoader) {
        this.unrealClassLoader = unrealClassLoader;
    }

    public UnrealClassLoader getUnrealClassLoader() {
        return unrealClassLoader;
    }

    public List<L2Property> readProperties(DataInput dataInput, String objClass, UnrealPackageReadOnly up) throws UnrealException {
        List<L2Property> properties = new ArrayList<>();

        List<Property> classTemplate = unrealClassLoader.getStructProperties(objClass);

        Collections.reverse(classTemplate);

        try {
            String name;
            while (!(name = up.getNameTable().get(dataInput.readCompactInt()).getName()).equals("None")) {
                int info = dataInput.readUnsignedByte();
                Type propertyType = Type.values()[info & 0b1111]; //TODO
                int sizeType = (info >> 4) & 0b111;
                boolean array = info >> 7 == 1;

                String structName = propertyType.equals(Type.STRUCT) ?
                        up.getNameTable().get(dataInput.readCompactInt()).getName() : null;
                int size = readPropertySize(sizeType, dataInput);
                int arrayIndex = array && !propertyType.equals(Type.BOOL) ? dataInput.readCompactInt() : 0;

                byte[] objBytes = new byte[size];
                dataInput.readFully(objBytes);

                final String n = name;
                PropertiesUtil.getAt(properties, n);
                L2Property property = PropertiesUtil.getAt(properties, n);
                if (property == null) {
                    Property template = classTemplate.stream()
                            .filter(pt -> pt.getEntry().getObjectName().getName().equalsIgnoreCase((n)))
                            .findAny()
                            .orElse(null);
                    if (template == null)
                        throw new UnrealException(objClass + ": Property template not found: " + name);

                    property = new L2Property(template, up);
                    properties.add(property);
                }

                if (structName != null &&
                        !"Vector".equals(structName) &&
                        !"Rotator".equals(structName) &&
                        !"Color".equals(structName)) {
                    StructProperty structProperty = (StructProperty) property.getTemplate();
                    structName = structProperty.getStructType().getObjectFullName();
                }
                UnrealPackageReadOnly.ExportEntry arrayInner = null;
                if (propertyType.equals(Type.ARRAY)) {
                    ArrayProperty arrayProperty = (ArrayProperty) property.getTemplate();
                    arrayInner = (UnrealPackageReadOnly.ExportEntry) arrayProperty.getInner();
                }

                DataInput objBuffer = new DataInputStream(new ByteArrayInputStream(objBytes), dataInput.getCharset());
                property.putAt(arrayIndex, read(objBuffer, propertyType, array, arrayInner, structName, up, objClass, property.getName()));
                property.setType(propertyType);
            }
        } catch (IOException e) {
            throw new UnrealException(e);
        }

        return properties;
    }

    private static int readPropertySize(int sizeType, DataInput dataInput) throws IOException {
        switch (sizeType) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 12;
            case 4:
                return 16;
            case 5:
                return dataInput.readUnsignedByte();
            case 6:
                return dataInput.readUnsignedShort();
            case 7:
                return dataInput.readInt();
            default:
                throw new IllegalArgumentException();
        }
    }

    private Object read(DataInput objBuffer, Type propertyType, boolean array, UnrealPackageReadOnly.ExportEntry arrayInner, String structName, UnrealPackageReadOnly up, String objClass, String pname) throws IOException {
        System.out.println("\t" + objClass + "->" + pname + " [" + propertyType.name() + "]");
        return read(objBuffer, propertyType, array, arrayInner, structName, up);
    }

    private Object read(DataInput objBuffer, Type propertyType, boolean array, UnrealPackageReadOnly.ExportEntry arrayInner, String structName, UnrealPackageReadOnly up) throws IOException {
        switch (propertyType) {
            case NONE:
                return null;
            case BYTE:
                return objBuffer.readUnsignedByte();
            case INT:
                return objBuffer.readInt();
            case BOOL:
                return array;
            case FLOAT:
                return objBuffer.readFloat();
            case OBJECT:
                return objBuffer.readCompactInt();
            case NAME:
                return objBuffer.readCompactInt();
            case ARRAY:
                int arraySize = objBuffer.readCompactInt();
                List<Object> arrayList = new ArrayList<>(arraySize);

                String a = arrayInner.getObjectClass().getObjectName().getName();
                Property f = unrealClassLoader.getProperty(arrayInner.getObjectFullName());

                array = false;
                arrayInner = null;
                structName = null;
                propertyType = Type.valueOf(a.replace("Property", "").toUpperCase());
                if (propertyType == Type.STRUCT) {
                    StructProperty structProperty = (StructProperty) f;
                    structName = structProperty.getStructType().getObjectFullName();
                }
                if (propertyType == Type.ARRAY) {
                    array = true;
                    ArrayProperty arrayProperty = (ArrayProperty) f;
                    arrayInner = (UnrealPackageReadOnly.ExportEntry) arrayProperty.getInner();
                }

                for (int i = 0; i < arraySize; i++) {
                    arrayList.add(read(objBuffer, propertyType, array, arrayInner, structName, up));
                }
                return arrayList;
            case STRUCT:
                return readStruct(objBuffer, structName, up);
            /*case VECTOR:
                return readStruct(objBuffer, "Vector", up);
            case ROTATOR:
                return readStruct(objBuffer, "Rotator", up);*/
            case STR:
                return objBuffer.readLine();
            default:
                throw new IllegalStateException("Unk type(" + structName + "): " + propertyType);
        }
    }

    private List<L2Property> readStruct(DataInput objBuffer, String structName, UnrealPackageReadOnly up) throws IOException {
        switch (structName) {
            case "Vector":
                return readStructBin(objBuffer, "Core.Object.Vector", up);
            case "Rotator":
                return readStructBin(objBuffer, "Core.Object.Rotator", up);
            case "Color":
                return readStructBin(objBuffer, "Core.Object.Color", up);
            default:
                return readProperties(objBuffer, structName, up);
        }
    }

    public List<L2Property> readStructBin(DataInput objBuffer, String structName, UnrealPackageReadOnly up) throws UnrealException {
        List<Property> properties = unrealClassLoader.getStructProperties(structName);

        try {
            switch (structName) {
                case "Core.Object.Vector": {
                    L2Property x = new L2Property(properties.get(0), up);
                    x.putAt(0, objBuffer.readFloat());
                    L2Property y = new L2Property(properties.get(1), up);
                    y.putAt(0, objBuffer.readFloat());
                    L2Property z = new L2Property(properties.get(2), up);
                    z.putAt(0, objBuffer.readFloat());
                    return Arrays.asList(x, y, z);
                }
                case "Core.Object.Rotator": {
                    L2Property pitch = new L2Property(properties.get(0), up);
                    pitch.putAt(0, objBuffer.readInt());
                    L2Property yaw = new L2Property(properties.get(1), up);
                    yaw.putAt(0, objBuffer.readInt());
                    L2Property roll = new L2Property(properties.get(2), up);
                    roll.putAt(0, objBuffer.readInt());
                    return Arrays.asList(pitch, yaw, roll);
                }
                case "Core.Object.Color": {
                    L2Property b = new L2Property(properties.get(0), up);
                    b.putAt(0, objBuffer.readUnsignedByte());
                    L2Property g = new L2Property(properties.get(1), up);
                    g.putAt(0, objBuffer.readUnsignedByte());
                    L2Property r = new L2Property(properties.get(2), up);
                    r.putAt(0, objBuffer.readUnsignedByte());
                    L2Property a = new L2Property(properties.get(3), up);
                    a.putAt(0, objBuffer.readUnsignedByte());
                    return Arrays.asList(b, g, r, a);
                }
                case "Fire.FireTexture.Spark": {
                    L2Property type = new L2Property(properties.get(0), up);
                    type.putAt(0, objBuffer.readUnsignedByte());
                    L2Property heat = new L2Property(properties.get(1), up);
                    heat.putAt(0, objBuffer.readUnsignedByte());
                    L2Property x = new L2Property(properties.get(2), up);
                    x.putAt(0, objBuffer.readUnsignedByte());
                    L2Property y = new L2Property(properties.get(3), up);
                    y.putAt(0, objBuffer.readUnsignedByte());
                    L2Property byteA = new L2Property(properties.get(4), up);
                    byteA.putAt(0, objBuffer.readUnsignedByte());
                    L2Property byteB = new L2Property(properties.get(5), up);
                    byteB.putAt(0, objBuffer.readUnsignedByte());
                    L2Property byteC = new L2Property(properties.get(6), up);
                    byteC.putAt(0, objBuffer.readUnsignedByte());
                    L2Property byteD = new L2Property(properties.get(7), up);
                    byteD.putAt(0, objBuffer.readUnsignedByte());
                    return Arrays.asList(type, heat, x, y, byteA, byteB, byteC, byteD);
                }
                default:
                    throw new UnsupportedOperationException("Not implemented"); //TODO
            }
        } catch (IOException e) {
            throw new UnrealException(e);
        }
    }

    public void writeProperties(DataOutput buffer, List<L2Property> list, UnrealPackageReadOnly up) throws UnrealException {
        try {
            for (L2Property property : list) {
                Property template = property.getTemplate();

                for (int i = 0; i < property.getSize(); i++) {
                    Object obj = property.getAt(i);
                    if (obj == null)
                        continue;

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    DataOutput objBuffer = new DataOutputStream(baos, buffer.getCharset());
                    AtomicBoolean array = new AtomicBoolean(i > 0);
                    AtomicReference<String> structName = new AtomicReference<>();
                    AtomicReference<Type> type = new AtomicReference<>(Type.valueOf(template.getClass().getSimpleName().replace("Property", "").toUpperCase()));
                    write(objBuffer, template, obj, array, structName, type, up);
                    byte[] bytes = baos.toByteArray();

                    int size = getPropertySize(bytes.length);
                    int ord = type.get().ordinal();
                    if (ord == 8) //FIXME
                        ord = 5;
                    int info = (array.get() ? 1 << 7 : 0) | (size << 4) | ord;

                    buffer.writeCompactInt(up.nameReference(template.getEntry().getObjectName().getName()));
                    buffer.writeByte(info);

                    if (type.get() == Type.STRUCT)
                        buffer.writeCompactInt(up.nameReference(structName.get()));
                    switch (size) {
                        case 5:
                            buffer.writeByte(bytes.length);
                            break;
                        case 6:
                            buffer.writeShort(bytes.length);
                            break;
                        case 7:
                            buffer.writeInt(bytes.length);
                            break;
                    }
                    if (i > 0)
                        buffer.writeByte(i);
                    buffer.write(bytes);
                }
            }
            buffer.writeCompactInt(up.nameReference("None"));
        } catch (IOException e) {
            throw new UnrealException(e);
        }
    }

    private void write(DataOutput objBuffer, Property template, Object obj, AtomicBoolean array, AtomicReference<String> structName, AtomicReference<Type> type, UnrealPackageReadOnly up) throws IOException {
        if (template instanceof ByteProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [BYTE]");
            objBuffer.writeByte((Integer) obj);
        } else if (template instanceof IntProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [INT]");
            objBuffer.writeInt((Integer) obj);
        } else if (template instanceof BoolProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [BOOL]");
            array.set((Boolean) obj);
        } else if (template instanceof FloatProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [FLOAT]");
            objBuffer.writeFloat((Float) obj);
        } else if (template instanceof ObjectProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [OBJ]");
            objBuffer.writeCompactInt((Integer) obj);
        } else if (template instanceof NameProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [NAME]");
            objBuffer.writeCompactInt((Integer) obj);
        } else if (template instanceof ArrayProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [ARRAY]");
            ArrayProperty arrayProperty = (ArrayProperty) template;

            List<Object> arrayList = (List<Object>) obj;
            objBuffer.writeCompactInt(arrayList.size());

            UnrealPackageReadOnly.ExportEntry arrayInner = (UnrealPackageReadOnly.ExportEntry) arrayProperty.getInner();
            String a = arrayInner.getObjectClass().getObjectName().getName();
            try {
                Class<? extends Property> pc = Class.forName("acmi.l2.clientmod.unreal." + a).asSubclass(Property.class);
                Property f = pc.getConstructor(ByteBuffer.class, UnrealPackageReadOnly.ExportEntry.class, PropertiesUtil.class)
                        .newInstance(ByteBuffer.wrap(arrayInner.getObjectRawDataExternally()).order(ByteOrder.LITTLE_ENDIAN), arrayInner, this);

                for (Object arrayObj : arrayList) {
                    write(objBuffer, f, arrayObj, new AtomicBoolean(), new AtomicReference<>(), new AtomicReference<>(), up);
                }
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
        } else if (template instanceof StructProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [STRUCT]");
            StructProperty structProperty = (StructProperty) template;
            structName.set(structProperty.getStructType().getObjectName().getName());
            writeStruct(objBuffer, structName.get(), up, (List<L2Property>) obj);
//            if (false) { //Not used in L2?
//                switch (structName.get()) {
//                    case "Vector":
//                        type.set(Type.VECTOR);
//                        break;
//                    case "Rotator":
//                        type.set(Type.ROTATOR);
//                        break;
//                }
//            }
        } else if (template instanceof StrProperty) {
            System.out.println(template.getEntry().getObjectInnerFullName() + " [STR]");
            objBuffer.writeLine((String) obj);
        } else {
            throw new UnsupportedOperationException(template.getClass().getSimpleName() + " serialization not implemented");
        }
    }

    private void writeStruct(DataOutput objBuffer, String structName, UnrealPackageReadOnly up, List<L2Property> struct) throws IOException {
        switch (structName) {
            case "Color":
                writeStructBin(objBuffer, struct, "Core.Object.Color", up);
                break;
            case "Vector":
                writeStructBin(objBuffer, struct, "Core.Object.Vector", up);
                break;
            case "Rotator":
                writeStructBin(objBuffer, struct, "Core.Object.Rotator", up);
                break;
            default:
                writeProperties(objBuffer, struct, up);
        }
    }

    public void writeStructBin(DataOutput objBuffer, List<L2Property> struct, String structName, UnrealPackageReadOnly up) throws UnrealException {
        try {
            switch (structName) {
                case "Core.Object.Color":
                    for (int i = 0; i < 4; i++)
                        objBuffer.writeByte((Integer) struct.get(i).getAt(0));
                    break;
                case "Core.Object.Vector":
                    for (int i = 0; i < 3; i++)
                        objBuffer.writeFloat((Float) struct.get(i).getAt(0));
                    break;
                case "Core.Object.Rotator":
                    for (int i = 0; i < 3; i++)
                        objBuffer.writeInt((Integer) struct.get(i).getAt(0));
                    break;
                case "Fire.FireTexture.Spark":
                    for (int i = 0; i < 8; i++)
                        objBuffer.writeByte((Integer) struct.get(i).getAt(0));
                    break;
                default:
                    throw new UnsupportedOperationException("not implemented"); //TODO
            }
        } catch (IOException e) {
            throw new UnrealException(e);
        }
    }

    private static int getPropertySize(int size) {
        switch (size) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 4:
                return 2;
            case 12:
                return 3;
            case 16:
                return 4;
            default:
                if (size <= 0xff) {
                    return 5;
                } else if (size <= 0xffff) {
                    return 6;
                } else {
                    return 7;
                }
        }
    }

    public enum Type {
        NONE,
        BYTE,
        INT,
        BOOL,
        FLOAT,
        OBJECT,
        NAME,
        STRING,
        CLASS,
        ARRAY,
        STRUCT,
        VECTOR,
        ROTATOR,
        STR,
        MAP,
        FIXED_ARRAY
    }

    public static L2Property getAt(List<L2Property> properties, String name) {
        return properties.stream()
                .filter(p -> p.getName().equalsIgnoreCase((name)))
                .findFirst()
                .orElse(null);
    }
}

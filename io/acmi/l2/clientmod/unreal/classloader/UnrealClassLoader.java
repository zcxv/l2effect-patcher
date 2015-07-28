/*
 * Copyright (c) 2014 acmi
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

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataInputStream;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.core.Class;
import acmi.l2.clientmod.unreal.core.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class UnrealClassLoader {
    //private static final Logger log = Logger.getLogger(UnrealClassLoader.class.getName());

    private final PackageLoader packageLoader;
    private final PropertiesUtil propertiesUtil;

    private final Map<String, Struct> structCache = new HashMap<>();
    private final Map<String, List<Field>> structFieldsCache = new HashMap<>();
    private final Map<String, Field> fieldsCache = new HashMap<>();

    private final Map<Integer, Function> nativeFunctions = new HashMap<>();

    public UnrealClassLoader(PackageLoader packageLoader) {
        this.packageLoader = packageLoader;
        this.propertiesUtil = new PropertiesUtil(this);
    }

    public PropertiesUtil getPropertiesUtil() {
        return propertiesUtil;
    }

    private UnrealPackageReadOnly.ExportEntry getExportEntry(String name, Predicate<UnrealPackageReadOnly.ExportEntry> condition) throws UnrealException {
        String[] path = name.split("\\.", 2);
        return packageLoader.apply(path[0])
                .getExportTable()
                .stream()
                .filter(e -> e.getObjectFullName().equalsIgnoreCase(name) && condition.test(e))
                .findAny()
                .orElseThrow(() -> new UnrealException(String.format("Entry %s not found.", name)));
    }

    public Struct getStruct(String structName) throws UnrealException {
        if (!structCache.containsKey(structName))
            loadStructTree(structName);

        return structCache.get(structName);
    }

    private Optional<Struct> getStructQuetly(String structName) {
        try {
            return Optional.of(getStruct(structName));
        } catch (UnrealException e) {
            return Optional.ofNullable(null);
        }
    }

    public List<Field> getStructFields(String structName) throws UnrealException {
        if (!structFieldsCache.containsKey(structName))
            loadStructTree(structName);

        return structFieldsCache.get(structName);
    }

    public Optional<List<Field>> getStructFieldsQuetly(String structName) {
        try {
            return Optional.of(getStructFields(structName));
        } catch (UnrealException e) {
            return Optional.ofNullable(null);
        }
    }

    private Struct getOrLoadStruct(String structName) throws IOException {
        return structCache.containsKey(structName) ?
                structCache.get(structName) :
                loadStruct(structName);
    }

    private void loadStructTree(String structName) throws UnrealException {
        try {
            List<Struct> list = new ArrayList<>();

            Struct tmp = getOrLoadStruct(structName);
            while (tmp != null) {
                list.add(tmp);

                UnrealPackageReadOnly.Entry superStruct = tmp.getEntry().getObjectSuperClass();
                tmp = superStruct != null ? getOrLoadStruct(superStruct.getObjectFullName()) : null;
            }

            Collections.reverse(list);

            System.out.println(String.format("%s", list));
            //log.info(() -> String.format("%s", list));

            List<Field> fields = new ArrayList<>();
            for (Struct struct : list) {
                String name = struct.getEntry().getObjectFullName();

                if (!structFieldsCache.containsKey(name)) {
                    UnrealPackageReadOnly.Entry childEntry = struct.getChild();
                    while (childEntry != null) {
                        Field field = getOrLoadField(childEntry);

                        fields.add(field);

                        childEntry = field.getNext();
                    }

                    structFieldsCache.put(name, Collections.unmodifiableList(new ArrayList<>(fields)));
                }

                fields = new ArrayList<>(structFieldsCache.get(name));

                if (!structCache.containsKey(name)) {
                    if (struct instanceof Class)
                        ((Class) struct).readProperties();

                    structCache.put(name, struct);
                }
            }
        } catch (IOException e) {
            throw new UnrealException(e);
        }
    }

    private Struct loadStruct(String name) throws IOException {
        UnrealPackageReadOnly.ExportEntry entry = getExportEntry(name, e -> {
            if (e.getObjectClass() == null)
                return true;
            String clazz = e.getObjectClass().getObjectFullName();
            return "Core.Function".equals(clazz) ||
                    "Core.Struct".equals(clazz) ||
                    "Core.State".equals(clazz);

        });
        DataInput buffer = new DataInputStream(new ByteArrayInputStream(entry.getObjectRawDataExternally()), entry.getOffset(), entry.getUnrealPackage().getCharset());
        Struct struct;
        switch (entry.getObjectClass() != null ? entry.getObjectClass().getObjectFullName() : "null") {
            case "Core.Function":
                Function function = new Function(buffer, entry, propertiesUtil);
                if (Function.Flag.getFlags(function.functionFlags).contains(Function.Flag.NATIVE))
                    nativeFunctions.put(function.nativeIndex, function);
                struct = function;
                break;
            case "Core.Struct":
                struct = new Struct(buffer, entry, propertiesUtil);
                break;
            case "Core.State":
                struct = new State(buffer, entry, propertiesUtil);
                break;
            default:
                struct = new Class(buffer, entry, propertiesUtil);
                break;
        }
        return struct;
    }

    private Field loadField(UnrealPackageReadOnly.ExportEntry entry) throws IOException, ReflectiveOperationException {
        DataInput buffer = new DataInputStream(new ByteArrayInputStream(entry.getObjectRawDataExternally()), entry.getUnrealPackage().getCharset());

        String fieldClassName = Field.class.getPackage().getName() + "." + entry.getObjectClass().getObjectName().getName();
        java.lang.Class<? extends Field> fieldClass = java.lang.Class.forName(fieldClassName).asSubclass(Field.class);

        return fieldClass.getConstructor(DataInput.class, UnrealPackageReadOnly.ExportEntry.class, PropertiesUtil.class)
                .newInstance(buffer, entry, propertiesUtil);
    }

    Field getOrLoadField(UnrealPackageReadOnly.Entry entry) throws UnrealException {
        String name = entry.getObjectFullName();
        if (!fieldsCache.containsKey(name)) {
            try {
                fieldsCache.put(name, loadField((UnrealPackageReadOnly.ExportEntry) entry));
            } catch (IOException | ReflectiveOperationException e) {
                throw new UnrealException(e);
            }
        }
        return fieldsCache.get(name);
    }

    public Function getNativeFunction(int index) throws UnrealException {
        return nativeFunctions.get(index);
    }

    public boolean isSubclass(String parent, String child) {
        if (parent.equalsIgnoreCase(child))
            return true;

        child = getSuperClass(child);

        return child != null && isSubclass(parent, child);
    }

    public String getSuperClass(String clazz) {
        Optional<Struct> childClass = getStructQuetly(clazz);
        if (childClass.isPresent()) {
            return childClass.get().getEntry().getObjectSuperClass().getObjectFullName();
        }
        return null;
    }
}

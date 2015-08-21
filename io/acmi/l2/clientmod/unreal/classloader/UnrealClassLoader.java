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

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataInputStream;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.core.Class;
import acmi.l2.clientmod.unreal.core.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.function.Predicate;

public class UnrealClassLoader {
    private final PackageLoader packageLoader;
    private final PropertiesUtil propertiesUtil;

    private Map<String, Struct> structCache = new HashMap<>();
    private Map<String, Property> propertyCache = new HashMap<>();
    private Map<String, List<Property>> structPropertiesCache = new HashMap<>();

    public UnrealClassLoader(PackageLoader packageLoader) {
        this.packageLoader = packageLoader;
        this.propertiesUtil = new PropertiesUtil(this);
    }

    public PropertiesUtil getPropertiesUtil() {
        return propertiesUtil;
    }

    public Optional<? extends UnrealPackageReadOnly.ExportEntry> getExportEntry(String name, Predicate<UnrealPackageReadOnly.ExportEntry> condition) throws UnrealException {
        if (name == null)
            return Optional.empty();

        String[] path = name.split("\\.", 2);
        return packageLoader.apply(path[0])
                .getExportTable()
                .stream()
                .filter(e -> e.getObjectFullName().equalsIgnoreCase(name) && condition.test(e))
                .findAny();
    }

    public Struct getStruct(String struct) {
        if (!structCache.containsKey(struct)) {
            getStructProperties(struct);
        }

        return structCache.get(struct);
    }

    private List<Property> loadStructProperties(String structName) {
        if (!structPropertiesCache.containsKey(structName)) {
            List<Property> fields = new ArrayList<>();
            Struct struct = (Struct) loadField(getExportEntry(structName, e -> true)
                    .orElseThrow(() -> new UnrealException(String.format("Struct %s not found.", structName))));
            UnrealPackageReadOnly.Entry childEntry = struct.getChild();
            while (childEntry != null) {
                UnrealPackageReadOnly.ExportEntry pEntry = getExportEntry(childEntry.getObjectFullName(), e -> true)
                        .orElseThrow(() -> new UnrealException(String.format("Child entry %s not found.", structName)));

                Field field = loadField(pEntry);

                if (field instanceof Property) {
                    Property p = (Property) field;
                    propertyCache.putIfAbsent(pEntry.getObjectFullName(), p);
                    fields.add(p);
                }

                childEntry = field.getNext();
            }
            structPropertiesCache.put(structName, fields);

            if (!structCache.containsKey(structName)) {
                if (struct instanceof Class)
                    try {
                        ((Class) struct).readProperties();
                    } catch (IOException e) {
                        throw new UnrealException(e);
                    }
                structCache.put(structName, struct);
            }
        }

        return structPropertiesCache.get(structName);
    }

    public List<Property> getStructProperties(String structName) {
        return getClassTree(structName).stream()
                .map(UnrealPackageReadOnly.Entry::getObjectFullName)
                .map(this::loadStructProperties)
                .reduce(new ArrayList<>(), (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
    }

    public Property getProperty(String property) {
        if (!propertyCache.containsKey(property)) {
            propertyCache.put(property, (Property) loadField(getExportEntry(property, e -> true)
                    .orElseThrow(() -> new UnrealException(String.format("Property %s not found.", property)))));
        }
        return propertyCache.get(property);
    }

    public String getSuperClass(String clazz) {
        try {
            return getStruct(clazz).getEntry().getObjectSuperClass().getObjectFullName();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isSubclass(String parent, String child) {
        if (parent.equalsIgnoreCase(child))
            return true;

        child = getSuperClass(child);

        return child != null && isSubclass(parent, child);
    }

    public List<UnrealPackageReadOnly.ExportEntry> getClassTree(String name) {
        List<UnrealPackageReadOnly.ExportEntry> tree = new ArrayList<>();

        Predicate<UnrealPackageReadOnly.ExportEntry> condition = e -> {
            if (e.getObjectClass() == null)
                return true;
            String clazz = e.getObjectClass().getObjectFullName();
            return "Core.Function".equals(clazz) ||
                    "Core.Struct".equals(clazz) ||
                    "Core.State".equals(clazz);

        };

        Optional<? extends UnrealPackageReadOnly.ExportEntry> eOptional;
        while((eOptional=getExportEntry(name, condition)).isPresent()){
            UnrealPackageReadOnly.ExportEntry entry = eOptional.get();
            tree.add(entry);
            name = entry.getObjectSuperClass() != null ?
                    entry.getObjectSuperClass().getObjectFullName() : null;
        }

        Collections.reverse(tree);

        return tree;
    }

    public Field loadField(UnrealPackageReadOnly.ExportEntry entry) {

        try {
            DataInput buffer = new DataInputStream(new ByteArrayInputStream(entry.getObjectRawDataExternally()), entry.getUnrealPackage().getCharset());

            String fieldClassName = Field.class.getPackage().getName() + "." +
                    (entry.getObjectClass() == null ? "Class" : entry.getObjectClass().getObjectName().getName());
            java.lang.Class<? extends Field> fieldClass = java.lang.Class.forName(fieldClassName).asSubclass(Field.class);

            return fieldClass.getConstructor(DataInput.class, UnrealPackageReadOnly.ExportEntry.class, PropertiesUtil.class)
                    .newInstance(buffer, entry, getPropertiesUtil());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (ReflectiveOperationException e) {
            throw new UnrealException(e);
        }
    }
}

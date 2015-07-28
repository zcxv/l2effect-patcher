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
package acmi.l2.clientmod.unreal.objectfactory;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataInputStream;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;
import acmi.l2.clientmod.unreal.classloader.UnrealClassLoader;
import acmi.l2.clientmod.unreal.core.Field;
import acmi.l2.clientmod.unreal.core.Object;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.function.Function;
import java.util.logging.Logger;

public class ObjectFactory implements Function<UnrealPackageReadOnly.ExportEntry, Object> {
    private static final Logger log = Logger.getLogger(ObjectFactory.class.getName());

    public static String unrealClassesPackage = "acmi.l2.clientmod.unreal";

    private final UnrealClassLoader classLoader;

    public ObjectFactory(UnrealClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public UnrealClassLoader getClassLoader() {
        return classLoader;
    }

    @Override
    public Object apply(UnrealPackageReadOnly.ExportEntry entry) throws UnrealException {
        java.lang.Class<? extends Object> clazz = null;
        if (entry.getObjectClass() == null || Field.class.isAssignableFrom(clazz = getClass(entry.getObjectClass().getObjectFullName())))
            throw new IllegalArgumentException(String.format("%s can only be loaded from classpath, use %s", entry.getObjectClass() == null ? "Class" : clazz.getSimpleName(), UnrealClassLoader.class.getSimpleName()));

        try {
            Constructor<? extends Object> constructor = clazz.getConstructor(DataInput.class, UnrealPackageReadOnly.ExportEntry.class, PropertiesUtil.class);
            ByteArrayInputStream bais = new ByteArrayInputStream(entry.getObjectRawDataExternally());
            DataInputStream dis = new DataInputStream(bais, entry.getOffset(), entry.getUnrealPackage().getCharset());
            Object object = constructor.newInstance(dis, entry, classLoader.getPropertiesUtil());
            if (dis.available() > 0)
                log.warning(() -> String.format("%d bytes of %s not read", bais.available(), object));
            return object;
        } catch (ReflectiveOperationException | IOException e) {
            throw new UnrealException(e);
        }
    }

    private java.lang.Class<? extends Object> getClass(String className) {
        if (className.equals("Core.Object"))
            return AsIsObject.class;

        Class<?> clazz = null;
        try {
            String javaClassName = unrealClassesPackage + "." + unrealClassNameToJavaClassName(className);
            log.fine(() -> String.format("%s -> %s", className, javaClassName));
            clazz = java.lang.Class.forName(javaClassName);
            return clazz.asSubclass(Object.class);
        } catch (ClassNotFoundException e) {
            log.fine(() -> String.format("Class %s not implemented in java", className));
        } catch (ClassCastException e) {
            Class<?> clazzLocal = clazz;
            log.warning(() -> String.format("%s is not subclass of %s", clazzLocal, Object.class));
        }

        String parent = classLoader.getSuperClass(className);
        if (parent == null)
            parent = "Core.Object";
        return getClass(parent);
    }

    private String unrealClassNameToJavaClassName(String className) {
        String[] path = className.split("\\.");
        return String.format("%s.%s", path[0].toLowerCase(), path[1]);
    }
}

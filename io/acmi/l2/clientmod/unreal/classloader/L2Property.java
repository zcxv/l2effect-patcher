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

import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil.Type;
import acmi.l2.clientmod.unreal.core.Property;

import java.util.Arrays;

public final class L2Property {
    private final Property template;
    private final Object[] value;
    private final UnrealPackageReadOnly up;
    private Type type;

    public L2Property(Property template, UnrealPackageReadOnly up) {
        this.template = template;
        this.value = new Object[template.arrayDimension];
        this.up = up;
    }

    public String getName() {
        return template.getEntry().getObjectName().getName();
    }

    public Property getTemplate() {
        return template;
    }

    public UnrealPackageReadOnly getUnrealPackage() {
        return up;
    }

    public int getSize() {
        return value.length;
    }

    public Object getAt(int index) {
        return value[index];
    }

    public void putAt(int index, Object value) {
        this.value[index] = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + template.getCategory() + "]" + template.getEntry().getObjectFullName() + "=" + Arrays.toString(value);
    }
}

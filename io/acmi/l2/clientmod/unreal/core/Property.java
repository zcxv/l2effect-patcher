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
package acmi.l2.clientmod.unreal.core;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Property extends Field {
    public final int arrayDimension;
    public final int elementSize;
    public final int propertyFlags;
    public final int category;
    public final int replicationOffset;

    public Property(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        super(input, entry, propertiesUtil);

        arrayDimension = input.readUnsignedShort();
        elementSize = input.readUnsignedShort();
        propertyFlags = input.readInt();
        category = input.readCompactInt();
        replicationOffset = (propertyFlags & 0x20) != 0 ? input.readUnsignedShort() : 0;
    }

    public String getCategory() {
        return getEntry().getUnrealPackage().getNameTable().get(category).getName();
    }

    public List<CPF> getPropertyFlags() {
        return Arrays.stream(CPF.values())
                .filter(e -> (e.getMask() & propertyFlags) != 0)
                .collect(Collectors.toList());
    }

    public Map<String, String> getInfo() {
        Map<String, String> props = new HashMap<>();

        if (arrayDimension != 1)
            props.put("arrayDimension", Integer.toString(arrayDimension));
        props.put("propertyFlags", getPropertyFlags().toString());

        return props;
    }

    @Override
    public String toString() {
        return getEntry() + ": " + getClass().getSimpleName() + getInfo();
    }

    public enum CPF {
        /**
         * Property is user-settable in the editor.
         */
        Edit(0x00000001),
        /**
         * Actor's property always matches class's default actor property.
         */
        Const(0x00000002),
        /**
         * Variable is writable by the input system.
         */
        Input(0x00000004),
        /**
         * Object can be exported with actor.
         */
        ExportObject(0x00000008),
        /**
         * Optional parameter (if CPF_Param is set).
         */
        OptionalParm(0x00000010),
        /**
         * Property is relevant to network replication (not specified in source code)
         */
        Net(0x00000020),
        /**
         * Reference to a constant object.
         */
        ConstRef(0x00000040),
        /**
         * Function/When call parameter
         */
        Parm(0x00000080),
        /**
         * Value is copied out after function call.
         */
        OutParm(0x00000100),
        /**
         * Property is a short-circuitable evaluation function parm.
         */
        SkipParm(0x00000200),
        /**
         * Return value.
         */
        ReturnParm(0x00000400),
        /**
         * Coerce args into this function parameter
         */
        CoerceParm(0x00000800),
        /**
         * Property is native: C++ code is responsible for serializing it.
         */
        Native(0x00001000),
        /**
         * Property is transient: shouldn't be saved, zerofilled at load time.
         */
        Transient(0x00002000),
        /**
         * Property should be loaded/saved as permanent profile.
         */
        Config(0x00004000),
        /**
         * Property should be loaded as localizable text
         */
        Localized(0x00008000),
        /**
         * Property travels across levels/servers.
         */
        Travel(0x00010000),
        /**
         * Property is uneditable in the editor
         */
        EditConst(0x00020000),
        /**
         * Load config from base class, not subclass.
         */
        GlobalConfig(0x00040000),
        /**
         * Object or dynamic array loaded on demand only.
         */
        OnDemand(0x00100000),
        /**
         * Automatically create inner object
         */
        New(0x00200000),
        /**
         * Fields need construction/destruction (not specified in source code)
         */
        NeedCtorLink(0x00400000),
        UNK1(0x00800000),
        UNK2(0x01000000),
        UNK3(0x02000000),
        UNK4(0x04000000),
        UNK5(0x08000000),
        UNK6(0x10000000),
        Deprecated(0x20000000),
        UNK8(0x40000000),
        UNK9(0x80000000);

        private int mask;

        CPF(int mask) {
            this.mask = mask;
        }

        public int getMask() {
            return mask;
        }

        @Override
        public String toString() {
            return "CPF_" + name();
        }
    }

}

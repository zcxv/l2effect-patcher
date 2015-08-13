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
import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.L2Property;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static acmi.l2.clientmod.io.UnrealPackageReadOnly.ObjectFlag.HasStack;
import static acmi.l2.clientmod.io.UnrealPackageReadOnly.ObjectFlag.getFlags;

public class Object {
    private UnrealPackageReadOnly.ExportEntry entry;
    protected final List<L2Property> properties = new ArrayList<>();

    private StateFrame stateFrame;

    public Object(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        this.entry = entry;

        if (getFlags(this.entry.getObjectFlags()).contains(HasStack)) {
            stateFrame = StateFrame.read(input);
        }

        if (!(this instanceof Class)) {
            System.out.println("Read " + entry.getObjectInnerFullName());
            properties.addAll(propertiesUtil.readProperties(input, this.entry.getObjectClass().getObjectFullName(), this.entry.getUnrealPackage()));
        }
    }

    protected Object() {
    }

    public void writeTo(DataOutput output, PropertiesUtil propertiesUtil) throws IOException {
        if (getFlags(entry.getObjectFlags()).contains(HasStack))
            stateFrame.writeTo(output);

        if (!(this instanceof Class))
            propertiesUtil.writeProperties(output, properties, entry.getUnrealPackage());
    }

    public UnrealPackageReadOnly.ExportEntry getEntry() {
        return entry;
    }

    public List<L2Property> getProperties() {
        return properties;
    }

    public StateFrame getStateFrame() {
        return stateFrame;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Object object = (Object) o;

        return entry.equals(object.entry);
    }

    @Override
    public int hashCode() {
        return entry.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s'%s'", entry.getObjectClass() == null ? "Class" : entry.getObjectClass().getObjectName().getName(), entry.getObjectInnerFullName());
    }

    public static class StateFrame {
        private int node;
        private int stateNode;
        private long probeMask;
        private int latentAction;
        private int offset;

        public StateFrame() {
        }

        public StateFrame(int node, int stateNode, long probeMask, int latentAction, int offset) {
            this.node = node;
            this.stateNode = stateNode;
            this.probeMask = probeMask;
            this.latentAction = latentAction;
            this.offset = offset;
        }

        public void writeTo(DataOutput output) throws IOException {
            output.writeCompactInt(node);
            output.writeCompactInt(stateNode);
            output.writeLong(probeMask);
            output.writeInt(latentAction);
            output.writeCompactInt(offset);
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getStateNode() {
            return stateNode;
        }

        public void setStateNode(int stateNode) {
            this.stateNode = stateNode;
        }

        public long getProbeMask() {
            return probeMask;
        }

        public void setProbeMask(long probeMask) {
            this.probeMask = probeMask;
        }

        public int getLatentAction() {
            return latentAction;
        }

        public void setLatentAction(int latentAction) {
            this.latentAction = latentAction;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public static StateFrame read(DataInput dataInput) throws IOException {
            return new StateFrame(
                    dataInput.readCompactInt(),
                    dataInput.readCompactInt(),
                    dataInput.readLong(),
                    dataInput.readInt(),
                    dataInput.readCompactInt());
        }
    }
}

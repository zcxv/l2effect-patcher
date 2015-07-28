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
package acmi.l2.clientmod.unreal.engine;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.io.UnrealPackageReadOnly;
import acmi.l2.clientmod.unreal.classloader.PropertiesUtil;

import java.io.IOException;

import static acmi.l2.clientmod.io.ByteUtil.compactIntToByteArray;

public class Texture extends BitmapMaterial {
    private final MipMapData[] mipMaps;

    public Texture(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        super(input, entry, propertiesUtil);

        mipMaps = new MipMapData[input.readCompactInt()];
        for (int i = 0; i < mipMaps.length; i++) {
            input.readInt();
            mipMaps[i] = new MipMapData(
                    input.readByteArray(),
                    input.readInt(),
                    input.readInt(),
                    input.readUnsignedByte(),
                    input.readUnsignedByte());
        }
    }

    @Override
    public void writeTo(DataOutput output, PropertiesUtil propertiesUtil) throws IOException {
        super.writeTo(output, propertiesUtil);

        output.writeCompactInt(mipMaps.length);
        for (MipMapData mipMapData : mipMaps) {
            byte[] len = compactIntToByteArray(mipMapData.data.length);
            output.writeInt(output.getPosition() + 4 + len.length + mipMapData.data.length);
            output.write(len);
            output.write(mipMapData.data);
            output.writeInt(mipMapData.width);
            output.writeInt(mipMapData.height);
            output.writeByte(mipMapData.widthBits);
            output.writeByte(mipMapData.heightBits);

        }
    }

    public MipMapData[] getMipMaps() {
        return mipMaps;
    }

    public static class MipMapData {
        private byte[] data;
        private int width, height;
        private int widthBits, heightBits;

        public MipMapData() {
        }

        public MipMapData(byte[] data, int width, int height, int widthBits, int heightBits) {
            this.data = data;
            this.width = width;
            this.height = height;
            this.widthBits = widthBits;
            this.heightBits = heightBits;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidthBits() {
            return widthBits;
        }

        public void setWidthBits(int widthBits) {
            this.widthBits = widthBits;
        }

        public int getHeightBits() {
            return heightBits;
        }

        public void setHeightBits(int heightBits) {
            this.heightBits = heightBits;
        }
    }
}

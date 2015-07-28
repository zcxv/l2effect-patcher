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

public class Font extends acmi.l2.clientmod.unreal.core.Object {
    private CharData[] charData;
    private UnrealPackageReadOnly.Entry[] textures;

    public Font(DataInput input, UnrealPackageReadOnly.ExportEntry entry, PropertiesUtil propertiesUtil) throws IOException {
        super(input, entry, propertiesUtil);

        charData = new CharData[input.readCompactInt()];
        for (int i = 0; i < charData.length; i++)
            charData[i] = new CharData(
                    input.readInt(),
                    input.readInt(),
                    input.readInt(),
                    input.readInt(),
                    input.readCompactInt());
        textures = new UnrealPackageReadOnly.Entry[input.readCompactInt()];
        for (int i = 0; i < textures.length; i++)
            textures[i] = entry.getUnrealPackage().objectReference(input.readCompactInt());
        input.skip(9);
    }

    @Override
    public void writeTo(DataOutput output, PropertiesUtil propertiesUtil) throws IOException {
        super.writeTo(output, propertiesUtil);

        output.writeCompactInt(charData.length);
        for (CharData charDataE : charData) {
            output.writeInt(charDataE.x);
            output.writeInt(charDataE.y);
            output.writeInt(charDataE.width);
            output.writeInt(charDataE.height);
            output.writeCompactInt(charDataE.textureInd);
        }
        output.writeCompactInt(textures.length);
        for (UnrealPackageReadOnly.Entry texture : textures)
            output.writeCompactInt(texture.getObjectReference());
        output.write(new byte[9]);
    }

    public CharData[] getCharData() {
        return charData;
    }

    public UnrealPackageReadOnly.Entry[] getTextures() {
        return textures;
    }

    public static class CharData {
        private int x, y, width, height;
        private int textureInd;

        public CharData(int x, int y, int width, int height, int textureInd) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.textureInd = textureInd;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
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

        public int getTextureInd() {
            return textureInd;
        }

        public void setTextureInd(int textureInd) {
            this.textureInd = textureInd;
        }
    }
}

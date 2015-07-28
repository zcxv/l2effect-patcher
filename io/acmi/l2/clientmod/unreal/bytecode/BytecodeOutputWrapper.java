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
package acmi.l2.clientmod.unreal.bytecode;

import acmi.l2.clientmod.io.DataOutput;

import java.io.IOException;
import java.nio.charset.Charset;

class BytecodeOutputWrapper implements BytecodeOutput {
    private DataOutput output;
    private int noneInd;
    private int size;

    BytecodeOutputWrapper(DataOutput output, int noneInd) {
        this.output = output;
        this.noneInd = noneInd;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int getNoneInd() {
        return noneInd;
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Charset getCharset() {
        return output.getCharset();
    }

    @Override
    public int getPosition() throws IOException {
        return output.getPosition();
    }

    @Override
    public void writeByte(int val) throws IOException {
        output.writeByte(val);
        size += 1;
    }

    @Override
    public void writeShort(int val) throws IOException {
        output.writeShort(val);
        size += 2;
    }

    @Override
    public void writeInt(int val) throws IOException {
        output.writeInt(val);
        size += 4;
    }

    @Override
    public void writeCompactInt(int val) throws IOException {
        output.writeCompactInt(val);
        size += 4;
    }

    @Override
    public void writeLong(long val) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeFloat(float val) throws IOException {
        output.writeFloat(val);
        size += 4;
    }

    @Override
    public void writeLine(String s) throws IOException {
        byte[] bytes = (s + '\0').getBytes(getCharset());
        write(bytes);
        size += bytes.length;
    }

    @Override
    public void writeBytes(String s) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeChars(String s) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeUTF(String s) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeByteArray(byte[] array) throws IOException {
        throw new UnsupportedOperationException();
    }
}

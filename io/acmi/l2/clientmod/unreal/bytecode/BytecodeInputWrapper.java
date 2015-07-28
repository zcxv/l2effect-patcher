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

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.unreal.bytecode.token.Token;
import acmi.l2.clientmod.util.IOFunction;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

class BytecodeInputWrapper implements BytecodeInput {
    private DataInput input;
    private int noneInd;
    private IOFunction<BytecodeInput, Token> tokenReader;
    private int size;

    BytecodeInputWrapper(DataInput input, int noneInd, IOFunction<BytecodeInput, Token> tokenReader) {
        this.input = input;
        this.noneInd = noneInd;
        this.tokenReader = tokenReader;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int getNoneInd() {
        return noneInd;
    }

    @Override
    public Charset getCharset() {
        return input.getCharset();
    }

    @Override
    public int getPosition() throws IOException {
        return input.getPosition();
    }

    @Override
    public int read() throws IOException {
        return input.read();
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void skip(int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int val = input.readUnsignedByte();
        size += 1;
        return val;
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int val = input.readUnsignedShort();
        size += 2;
        return val;
    }

    @Override
    public int readInt() throws IOException {
        int val = input.readInt();
        size += 4;
        return val;
    }

    @Override
    public int readCompactInt() throws IOException {
        int val = input.readCompactInt();
        size += 4;
        return val;
    }

    @Override
    public long readLong() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public float readFloat() throws IOException {
        float val = input.readFloat();
        size += 4;
        return val;
    }

    @Override
    public String readLine() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        do {
            b = readUnsignedByte();
            baos.write(b);
        } while (b != 0);
        String s = baos.toString(getCharset().name());
        //size += s.length();
        return s.substring(0, s.length() - 1);
    }

    @Override
    public String readUTF() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public byte[] readByteArray() throws IOException {
        throw new UnsupportedOperationException();
    }

    public Token readToken() throws IOException {
        return tokenReader.apply(this);
    }
}

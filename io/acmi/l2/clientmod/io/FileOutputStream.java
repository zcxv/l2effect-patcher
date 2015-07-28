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
package acmi.l2.clientmod.io;

import acmi.l2.clientmod.crypt.blowfish.L2Ver21xOutputStream;
import acmi.l2.clientmod.crypt.rsa.L2Ver41xOutputStream;
import acmi.l2.clientmod.crypt.xor.L2Ver120OutputStream;
import acmi.l2.clientmod.crypt.xor.L2Ver1x1OutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import static acmi.l2.clientmod.crypt.blowfish.L2Ver21x.BLOWFISH_KEY_211;
import static acmi.l2.clientmod.crypt.blowfish.L2Ver21x.BLOWFISH_KEY_212;
import static acmi.l2.clientmod.crypt.rsa.L2Ver41x.MODULUS_L2ENCDEC;
import static acmi.l2.clientmod.crypt.rsa.L2Ver41x.PUBLIC_EXPONENT_L2ENCDEC;
import static acmi.l2.clientmod.crypt.xor.L2Ver1x1.XOR_KEY_111;
import static acmi.l2.clientmod.crypt.xor.L2Ver1x1.getXORKey121;

public class FileOutputStream extends FinishableOutputStream {
    private FinishableOutputStream stream;
    private boolean writeTail;

    private boolean finished;

    public FileOutputStream(OutputStream output, String name, int version, boolean writeTail) throws IOException {
        super(output);
        this.stream = getOutputStream(output, name, version);
        this.writeTail = writeTail;
        writeHeader(version);
    }

    private void writeHeader(int version) throws IOException {
        out.write(("Lineage2Ver" + version).getBytes(Charset.forName("utf-16le")));
    }

    public static FinishableOutputStream getOutputStream(OutputStream output, String name, int version) {
        switch (version) {
            //XOR
            case 111:
            case 121:
                return new L2Ver1x1OutputStream(output, version == 111 ?
                        XOR_KEY_111 :
                        getXORKey121(name));
            case 120:
                return new L2Ver120OutputStream(output);
            //BLOWFISH
            case 211:
            case 212:
                return new L2Ver21xOutputStream(output, version == 211 ?
                        BLOWFISH_KEY_211 :
                        BLOWFISH_KEY_212);
            //RSA
            case 411:
            case 412:
            case 413:
            case 414:
                return new L2Ver41xOutputStream(output, MODULUS_L2ENCDEC, PUBLIC_EXPONENT_L2ENCDEC);
            default:
                throw new RuntimeException("Unsupported version: " + version);
        }
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void finish() throws IOException {
        if (finished)
            return;

        finished = true;

        stream.finish();

        if (writeTail) {
            //TODO
            for (int i = 0; i < 20; i++)
                out.write(0);
        }
        out.flush();
    }
}

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

import acmi.l2.clientmod.crypt.blowfish.L2Ver21xInputStream;
import acmi.l2.clientmod.crypt.rsa.L2Ver41xInputStream;
import acmi.l2.clientmod.crypt.xor.L2Ver120InputStream;
import acmi.l2.clientmod.crypt.xor.L2Ver1x1InputStream;

import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

import static acmi.l2.clientmod.crypt.blowfish.L2Ver21x.BLOWFISH_KEY_211;
import static acmi.l2.clientmod.crypt.blowfish.L2Ver21x.BLOWFISH_KEY_212;
import static acmi.l2.clientmod.crypt.rsa.L2Ver41x.*;
import static acmi.l2.clientmod.crypt.xor.L2Ver1x1.XOR_KEY_111;
import static acmi.l2.clientmod.crypt.xor.L2Ver1x1.getXORKey121;

public class FileInputStream extends FilterInputStream {

    public FileInputStream(InputStream input, String name, boolean l2encdec) throws IOException {
        super(getInputStream(input, name, l2encdec));
    }

    public static InputStream getInputStream(InputStream input, int version, String name, boolean l2encdec) throws IOException {
        switch (version) {
            //XOR
            case 111:
            case 121:
                return new L2Ver1x1InputStream(input, version == 111 ?
                        XOR_KEY_111 :
                        getXORKey121(name));
            case 120:
                return new L2Ver120InputStream(input);
            //BLOWFISH
            case 211:
            case 212:
                return new L2Ver21xInputStream(input, version == 211 ?
                        BLOWFISH_KEY_211 :
                        BLOWFISH_KEY_212);
            //RSA
            case 411:
            case 412:
            case 413:
            case 414:
                BigInteger modulus = l2encdec ? MODULUS_L2ENCDEC : RSA_KEYS[version - 411][0];
                BigInteger exponent = l2encdec ? PRIVATE_EXPONENT_L2ENCDEC : RSA_KEYS[version - 411][1];
                return new L2Ver41xInputStream(input, modulus, exponent);
            default:
                throw new RuntimeException("Unsupported version: " + version);
        }
    }

    public static InputStream getInputStream(InputStream input, String name, boolean l2encdec) throws IOException {
        int version = readVersion(input);

        return getInputStream(input, version, name, l2encdec);
    }

    public static int readVersion(InputStream input) throws IOException {
        byte[] header = new byte[28];
        new DataInputStream(input).readFully(header);
        String headerStr = new String(header, Charset.forName("utf-16le"));
        if (!headerStr.matches("Lineage2Ver\\d{3}"))
            throw new IOException("Not a Lineage 2 file");

        return Integer.valueOf(headerStr.substring(11));
    }

    private static final BigInteger RSA_KEYS[][] = new BigInteger[][]{
            {MODULUS_411, PRIVATE_EXPONENT_411},
            {MODULUS_412, PRIVATE_EXPONENT_412},
            {MODULUS_413, PRIVATE_EXPONENT_413},
            {MODULUS_414, PRIVATE_EXPONENT_414}
    };
}

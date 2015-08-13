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

import acmi.l2.clientmod.unreal.bytecode.token.EndFunctionParams;
import acmi.l2.clientmod.unreal.bytecode.token.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BytecodeInput {
    int getNoneInd();

    int getSize();

    int readUnsignedByte() throws IOException;

    int readUnsignedShort() throws IOException;

    int readInt() throws IOException;

    int readCompactInt() throws IOException;

    float readFloat() throws IOException;

    String readLine() throws IOException;

    Token readToken() throws IOException;

    default Token[] readFunctionParams() throws IOException {
        List<Token> tokens = new ArrayList<>();
        Token tmp;
        do {
            tmp = readToken();
            if (tmp instanceof EndFunctionParams)
                break;
            tokens.add(tmp);
        } while (true);
        return tokens.toArray(new Token[tokens.size()]);
    }
}

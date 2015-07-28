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
package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;
import java.util.Arrays;

public class VirtualFunction extends Token {
    public static final int OPCODE = 0x1b;

    private final int nameRef;
    private final Token[] params;

    public VirtualFunction(int nameRef, Token[] params) {
        this.nameRef = nameRef;
        this.params = params;
    }

    public static VirtualFunction readFrom(BytecodeInput input) throws IOException {
        return new VirtualFunction(input.readCompactInt(), input.readFunctionParams());
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    public int getNameRef() {
        return nameRef;
    }

    public Token[] getParams() {
        return params;
    }

    @Override
    public void writeTo(BytecodeOutput output) throws IOException {
        super.writeTo(output);
        output.writeCompactInt(nameRef);
        output.writeFunctionParams(params);
    }

    @Override
    public String toString() {
        return "VirtualFunction{" +
                "nameRef=" + nameRef +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}

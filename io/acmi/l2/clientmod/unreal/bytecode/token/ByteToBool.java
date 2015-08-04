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
import acmi.l2.clientmod.unreal.bytecode.token.annotation.ConversionToken;

import java.io.IOException;

@ConversionToken
public class ByteToBool extends Token {
    public static final int OPCODE = 0x3b;

    private final Token value;

    public ByteToBool(Token value) {
        this.value = value;
    }

    public static ByteToBool readFrom(BytecodeInput input) throws IOException {
        return new ByteToBool(input.readToken());
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    public Token getValue() {
        return value;
    }

    @Override
    public void writeTo(BytecodeOutput output) throws IOException {
        super.writeTo(output);
        output.writeToken(value);
    }

    @Override
    public String toString() {
        return "ByteToBool("
                + value
                + ')';
    }
}

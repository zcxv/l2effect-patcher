package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class NativeFunctionCall extends Token {
    private final int nativeIndex;
    private final Token[] params;

    public NativeFunctionCall(int nativeIndex, Token... params) {
        this.nativeIndex = nativeIndex;
        this.params = params;
    }

    public static NativeFunctionCall readFrom(BytecodeInput input, int nativeIndex) throws IOException {
        return new NativeFunctionCall(nativeIndex, input.readFunctionParams());
    }

    @Override
    protected int getOpcode() {
        return nativeIndex;
    }

    @Override
    protected void writeOpcode(BytecodeOutput output, int opcode) throws IOException {
        if (opcode > 0xff) {
            output.writeByte(0x60 + ((opcode >> 8) & 0x0f));
            output.writeByte(opcode & 0xff);
        } else {
            output.writeByte(opcode);
        }
    }

    public int getNativeIndex() {
        return nativeIndex;
    }

    public Token[] getParams() {
        return params;
    }

    @Override
    public void writeTo(BytecodeOutput output) throws IOException {
        super.writeTo(output);
        output.writeFunctionParams(params);
    }

    @Override
    public String toString() {
        return "NativeFunctionCall("
                + nativeIndex
                + (params == null || params.length == 0 ? "" : ", " + Arrays.stream(params).map(Objects::toString).collect(Collectors.joining(", ")))
                + ')';
    }
}

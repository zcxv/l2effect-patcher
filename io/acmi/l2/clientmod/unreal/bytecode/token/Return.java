package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;

public class Return extends Token {
    public static final int OPCODE = 0x04;

    private final Token value;

    public Return(Token value) {
        this.value = value;
    }

    public static Return readFrom(BytecodeInput input) throws IOException {
        return new Return(input.readToken());
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
        return "Return("
                + value
                + ')';
    }
}

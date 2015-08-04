package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;

import java.io.IOException;

public class Nothing extends Token {
    public static final int OPCODE = 0x0b;

    public static final Nothing INSTANCE = new Nothing();

    private Nothing() {
    }

    public static Nothing readFrom(BytecodeInput input) throws IOException {
        return INSTANCE;
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    @Override
    public String toString() {
        return "Nothing()";
    }
}

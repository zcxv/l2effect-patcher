package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;

import java.io.IOException;

public class Stop extends Token {
    public static final int OPCODE = 0x08;

    public static final Stop INSTANCE = new Stop();

    private Stop() {
    }

    public static Stop readFrom(BytecodeInput input) throws IOException {
        return INSTANCE;
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    @Override
    public String toString() {
        return "Stop";
    }
}

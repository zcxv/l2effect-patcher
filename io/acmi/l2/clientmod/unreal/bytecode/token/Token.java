package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;

public abstract class Token {
    protected abstract int getOpcode();

    protected void writeOpcode(DataOutput output, int opcode) throws IOException {
        output.writeByte(opcode);
    }

    public void writeTo(BytecodeOutput output) throws IOException {
        writeOpcode(output, getOpcode());
    }
}

package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;

public class LocalVariable extends Token {
    public static final int OPCODE = 0x00;

    private int objRef;

    public LocalVariable(int objRef) {
        this.objRef = objRef;
    }

    public static LocalVariable readFrom(BytecodeInput input) throws IOException {
        return new LocalVariable(input.readCompactInt());
    }

    @Override
    protected int getOpcode() {
        return OPCODE;
    }

    public int getObjRef() {
        return objRef;
    }

    @Override
    public void writeTo(BytecodeOutput output) throws IOException {
        super.writeTo(output);
        output.writeCompactInt(objRef);
    }

    @Override
    public String toString() {
        return "LocalVariable("
                + objRef
                + ')';
    }
}

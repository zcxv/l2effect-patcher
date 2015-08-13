package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;

public class InstanceVariable extends Token {
    public static final int OPCODE = 0x01;

    private int objRef;

    public InstanceVariable(int objRef) {
        this.objRef = objRef;
    }

    public static InstanceVariable readFrom(BytecodeInput input) throws IOException {
        return new InstanceVariable(input.readCompactInt());
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
        return "InstanceVariable("
                + objRef
                + ')';
    }
}

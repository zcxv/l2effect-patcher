package acmi.l2.clientmod.unreal.bytecode.token;

import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeInput;
import acmi.l2.clientmod.unreal.bytecode.BytecodeOutput;

import java.io.IOException;
import java.util.Arrays;

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
    protected void writeOpcode(DataOutput output, int opcode) throws IOException {
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
        for (Token param : params)
            param.writeTo(output);
        EndFunctionParams.INSTANCE.writeTo(output);
    }

//    @Override
//    public String toString() {
    //        if (nativeFunction.isPreOperator() ||
//                (nativeFunction.isOperator() && nativeFunction.getOperatorPrecedence() == 0)) {
//            Token p = readToken(input);
//            Token end = readToken(input);
//            if (!(end instanceof EndFunctionParams))
//                throw new IOException(EndFunctionParams.class.getSimpleName() + " expected");
//            return new NativeFunctionCall(unrealPackage, nativeFunction, p);
//        } else if (nativeFunction.isOperator()) {
//            Token p1 = readToken(input);
//            Token p2 = readToken(input);
//            Token end = readToken(input);
//            if (!(end instanceof EndFunctionParams))
//                throw new IOException(String.format("%s expected, %s function params: p1=%s, p2=%s, end=%s", EndFunctionParams.class.getSimpleName(), nativeFunction.getName(), p1, p2, end));
//            return new NativeFunctionCall(unrealPackage, nativeFunction, p1, p2);
//        } else {
//            return new NativeFunctionCall(unrealPackage, nativeFunction, readFunctionParams(input));
//        }
//        return nativeFunction.getName() + Arrays.toString(params);//TODO
//    }

    @Override
    public String toString() {
        return "NativeFunctionCall{" +
                "nativeIndex=" + nativeIndex +
                ", params=" + Arrays.toString(params) +
                '}';
    }
}

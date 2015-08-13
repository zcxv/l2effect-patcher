package acmi.l2.clientmod.unreal.bytecode;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.bytecode.token.*;
import acmi.l2.clientmod.unreal.bytecode.token.annotation.ConversionToken;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytecodeUtil {
    private static final int EX_ExtendedNative = 0x60;
    private static final int EX_FirstNative = 0x70;

    private static final Map<Integer, Method> mainTokenTable = new HashMap<>();
    private static final Map<Integer, Method> conversionTokenTable = new HashMap<>();

    private int noneInd;

    public BytecodeUtil(int noneInd) {
        this.noneInd = noneInd;
    }

    public int getNoneInd() {
        return noneInd;
    }

    public BytecodeInput createBytecodeInput(DataInput input) {
        return new BytecodeInputWrapper(input, getNoneInd(), this::readToken);
    }

    public BytecodeOutput createBytecodeOutput(DataOutput output) {
        return new BytecodeOutputWrapper(output, noneInd);
    }

    public List<Token> readTokens(DataInput input, int scriptSize) throws IOException {
        BytecodeInput wrapper = createBytecodeInput(input);

        List<Token> tokens = new ArrayList<>();
        while (wrapper.getSize() < scriptSize) {
            tokens.add(readToken(wrapper));
        }

        return tokens;
    }

    private Token readToken(BytecodeInput input) throws IOException {
        int opcode = input.readUnsignedByte();
        Map<Integer, Method> table;
        String tableName;
        if (opcode == ConversionTable.OPCODE) {
            opcode = input.readUnsignedByte();

            table = conversionTokenTable;
            tableName = "Conversion";
        } else {
            if (opcode >= EX_ExtendedNative)
                return readNativeCall(input, opcode);

            table = mainTokenTable;
            tableName = "Main";
        }

        Method constructorMethod = table.get(opcode);

        if (constructorMethod == null)
            throw new IOException(String.format("Unknown token: %02x, table: %s", opcode, tableName));

        try {
            return (Token) constructorMethod.invoke(null, input);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof IOException)
                throw (IOException) targetException;
            throw new UnrealException("Read token error", targetException);
        }
    }

    private Token readNativeCall(BytecodeInput input, int b) throws IOException {
        int nativeIndex = (b & 0xF0) == EX_ExtendedNative ?
                ((b - EX_ExtendedNative) << 8) + input.readUnsignedByte() : b;

        if (nativeIndex < EX_FirstNative)
            throw new UnrealException("Invalid native index: " + nativeIndex);

        return NativeFunctionCall.readFrom(input, nativeIndex);
    }

    public int writeTokens(DataOutput output, Token... tokens) throws IOException {
        BytecodeOutputWrapper wrapper = new BytecodeOutputWrapper(output, noneInd);
        for (Token token : tokens)
            wrapper.writeToken(token);
        return wrapper.getSize();
    }

    public int writeTokens(DataOutput output, Iterable<Token> tokens) throws IOException {
        BytecodeOutputWrapper wrapper = new BytecodeOutputWrapper(output, noneInd);
        for (Token token : tokens)
            wrapper.writeToken(token);
        return wrapper.getSize();
    }

    static {
        //Main
        register(LocalVariable.class);     //00
        register(InstanceVariable.class);  //01
        register(DefaultVariable.class);   //02

        register(Return.class);            //04
        register(Switch.class);            //05
        register(Jump.class);              //06
        register(JumpIfNot.class);         //07
        register(Stop.class);              //08
        register(Assert.class);            //09
        register(Case.class);              //0a
        register(Nothing.class);           //0b
        register(LabelTable.class);        //0c
        register(GotoLabel.class);         //0d
        register(EatString.class);         //0e
        register(Let.class);               //0f
        register(DynArrayElement.class);   //10
        register(New.class);               //11
        register(ClassContext.class);      //12
        register(Metacast.class);          //13
        register(LetBool.class);           //14

        register(EndFunctionParams.class); //16
        register(Self.class);              //17
        register(Skip.class);              //18
        register(Context.class);           //19
        register(ArrayElement.class);      //1a
        register(VirtualFunction.class);   //1b
        register(FinalFunction.class);     //1c
        register(IntConst.class);          //1d
        register(FloatConst.class);        //1e
        register(StringConst.class);       //1f
        register(ObjectConst.class);       //20
        register(NameConst.class);         //21
        register(RotatorConst.class);      //22
        register(VectorConst.class);       //23
        register(ByteConst.class);         //24
        register(IntZero.class);           //25
        register(IntOne.class);            //26
        register(True.class);              //27
        register(False.class);             //28
        register(NativeParam.class);       //29
        register(NoObject.class);          //2a

        register(IntConstByte.class);      //2c
        register(BoolVariable.class);      //2d
        register(DynamicCast.class);       //2e
        register(Iterator.class);          //2f
        register(IteratorPop.class);       //30
        register(IteratorNext.class);      //31
        register(StructCmpEq.class);       //32
        register(StructCmpNe.class);       //33

        register(StructMember.class);      //36
        register(Length.class);            //37
        register(GlobalFunction.class);    //38
        register(ConversionTable.class);   //39
        register(Insert.class);            //40
        register(Remove.class);            //41

        register(DelegateName.class);      //44

        //Conversion
        register(ByteToInt.class);         //3a
        register(ByteToBool.class);        //3b
        register(ByteToFloat.class);       //3c
        register(IntToByte.class);         //3d
        register(IntToBool.class);         //3e
        register(IntToFloat.class);        //3f
        register(BoolToByte.class);        //40
        register(BoolToInt.class);         //41
        register(BoolToFloat.class);       //42
        register(FloatToByte.class);       //43
        register(FloatToInt.class);        //44
        register(FloatToBool.class);       //45

        register(StringToInt.class);       //4a
        register(StringToBool.class);      //4b
        register(StringToFloat.class);     //4c
        register(StringToVector.class);    //4d
        register(StringToRotator.class);   //4e
        register(VectorToBool.class);      //4f
        register(VectorToRotator.class);   //50
        register(RotatorToBool.class);     //51
        register(ByteToString.class);      //52
        register(IntToString.class);       //53
        register(BoolToString.class);      //54
        register(FloatToString.class);     //55
        register(ObjectToString.class);    //56
        register(NameToString.class);      //57
        register(VectorToString.class);    //58
        register(RotatorToString.class);   //59

        register(ByteToINT64.class);       //5a
        register(IntToINT64.class);        //5b
        register(BoolToINT64.class);       //5c
        register(FloatToINT64.class);      //5d
        register(StringToINT64.class);     //5e
        register(INT64ToByte.class);       //5f
        register(INT64ToInt.class);        //60
        register(INT64ToBool.class);       //61
        register(INT64ToFloat.class);      //62
        register(INT64ToString.class);     //63
    }

    static void register(Class<? extends Token> clazz) {
        Map<Integer, Method> table;

        if (clazz.isAnnotationPresent(ConversionToken.class)) {
            table = conversionTokenTable;
        } else {
            table = mainTokenTable;
        }

        try {
            table.put(clazz.getDeclaredField("OPCODE").getInt(null), clazz.getDeclaredMethod("readFrom", BytecodeInput.class));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(String.format("Couldn't register %s opcode", clazz), e);
        }
    }
}
package acmi.l2.clientmod.unreal.bytecode;

import acmi.l2.clientmod.io.DataInput;
import acmi.l2.clientmod.io.DataOutput;
import acmi.l2.clientmod.unreal.UnrealException;
import acmi.l2.clientmod.unreal.bytecode.token.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BytecodeUtil {
    private static final Logger log = Logger.getLogger(BytecodeUtil.class.getName());

    private static final int EX_ExtendedNative = 0x60;
    private static final int EX_FirstNative = 0x70;

    private static final Map<Integer, Method> mainTokenTable = new HashMap<>();
    private static final Map<Integer, Method> conversionTokenTable = new HashMap<>();

    private int noneInd;
    private Map<Integer, Method> table = mainTokenTable;

    public BytecodeUtil(int noneInd) {
        this.noneInd = noneInd;
    }

    public int getNoneInd() {
        return noneInd;
    }

    public BytecodeInput createBytecodeInput(DataInput input) {
        return new BytecodeInputWrapper(input, noneInd, this::readToken);
    }

    public BytecodeOutput createBytecodeOutput(DataOutput output) {
        return new BytecodeOutputWrapper(output, noneInd);
    }

    public List<Token> readTokens(DataInput input, int scriptSize) throws UnrealException {
        List<Token> tokens = new ArrayList<>();
        try {
            BytecodeInput wrapper = createBytecodeInput(input);
            while (wrapper.getSize() < scriptSize) {
                log.fine(() -> String.format("\t%d/%d", wrapper.getSize(), scriptSize));
                Token token = readToken(wrapper);
                log.fine(() -> String.format("\t%s", token));
                tokens.add(token);
            }
        } catch (Exception e) {
            throw new UnrealException(e);
        }
        return tokens;
    }

    private Token readToken(BytecodeInput input) throws IOException {
        int opcode = input.readUnsignedByte();
        Method constructor = table.get(opcode);
        if (opcode >= EX_ExtendedNative && constructor == null)
            return readNativeCall(input, opcode);
        if (constructor == null)
            throw new IOException(String.format("Unknown token: %02x, table: %s", opcode, table == mainTokenTable ? "mainTokenTable" : "conversionTokenTable"));
        Token token;
        try {
            if (opcode == ConversionTable.OPCODE) {
                table = conversionTokenTable;
                token = (Token) constructor.invoke(null, input);
                table = mainTokenTable;
            } else {
                token = (Token) constructor.invoke(null, input);
            }
        } catch (Exception e) {
            throw new IllegalStateException("Read token error", e);
        }
        log.fine(() -> String.format("\t\t%s", token));
        return token;
    }

    private Token readNativeCall(BytecodeInput input, int b) throws IOException {
        int nativeIndex;
        if ((b & 0xF0) == EX_ExtendedNative) {
            nativeIndex = ((b - EX_ExtendedNative) << 8) + input.readUnsignedByte();
        } else {
            nativeIndex = b;
        }
        if (nativeIndex < EX_FirstNative)
            throw new IllegalStateException("Invalid native index " + nativeIndex + " b=" + b);
        return NativeFunctionCall.readFrom(input, nativeIndex);
    }

    public int writeTokens(DataOutput output, List<Token> tokens) throws UnrealException {
        try {
            BytecodeOutputWrapper wrapper = new BytecodeOutputWrapper(output, noneInd);
            for (Token token : tokens)
                wrapper.writeToken(token);
            return wrapper.getSize();
        } catch (Exception e) {
            throw new UnrealException(e);
        }
    }

    static {
        register(LocalVariable.class, mainTokenTable);     //00
        register(InstanceVariable.class, mainTokenTable);  //01
        register(DefaultVariable.class, mainTokenTable);   //02

        register(Return.class, mainTokenTable);            //04
        register(Switch.class, mainTokenTable);            //05
        register(Jump.class, mainTokenTable);              //06
        register(JumpIfNot.class, mainTokenTable);         //07
        register(Stop.class, mainTokenTable);              //08
        register(Assert.class, mainTokenTable);            //09
        register(Case.class, mainTokenTable);              //0a
        register(Nothing.class, mainTokenTable);           //0b
        register(LabelTable.class, mainTokenTable);        //0c
        register(GotoLabel.class, mainTokenTable);         //0d
        register(EatString.class, mainTokenTable);         //0e
        register(Let.class, mainTokenTable);               //0f
        register(DynArrayElement.class, mainTokenTable);   //10
        register(New.class, mainTokenTable);               //11
        register(ClassContext.class, mainTokenTable);      //12
        register(Metacast.class, mainTokenTable);          //13
        register(LetBool.class, mainTokenTable);           //14

        register(EndFunctionParams.class, mainTokenTable); //16
        register(Self.class, mainTokenTable);              //17
        register(Skip.class, mainTokenTable);              //18
        register(Context.class, mainTokenTable);           //19
        register(ArrayElement.class, mainTokenTable);      //1a
        register(VirtualFunction.class, mainTokenTable);   //1b
        register(FinalFunction.class, mainTokenTable);     //1c
        register(IntConst.class, mainTokenTable);          //1d
        register(FloatConst.class, mainTokenTable);        //1e
        register(StringConst.class, mainTokenTable);       //1f
        register(ObjectConst.class, mainTokenTable);       //20
        register(NameConst.class, mainTokenTable);         //21
        register(RotatorConst.class, mainTokenTable);      //22
        register(VectorConst.class, mainTokenTable);       //23
        register(ByteConst.class, mainTokenTable);         //24
        register(IntZero.class, mainTokenTable);           //25
        register(IntOne.class, mainTokenTable);            //26
        register(True.class, mainTokenTable);              //27
        register(False.class, mainTokenTable);             //28
        register(NativeParam.class, mainTokenTable);       //29
        register(NoObject.class, mainTokenTable);          //2a

        register(IntConstByte.class, mainTokenTable);      //2c
        register(BoolVariable.class, mainTokenTable);      //2d
        register(DynamicCast.class, mainTokenTable);       //2e
        register(Iterator.class, mainTokenTable);          //2f
        register(IteratorPop.class, mainTokenTable);       //30
        register(IteratorNext.class, mainTokenTable);      //31
        register(StructCmpEq.class, mainTokenTable);       //32
        register(StructCmpNe.class, mainTokenTable);       //33


        register(StructMember.class, mainTokenTable);      //36
        register(Length.class, mainTokenTable);            //37
        register(GlobalFunction.class, mainTokenTable);    //38
        register(ConversionTable.class, mainTokenTable);   //39
        register(ByteToInt.class, mainTokenTable);         //3a
        register(ByteToBool.class, mainTokenTable);        //3b
        register(ByteToFloat.class, mainTokenTable);       //3c
        register(IntToByte.class, mainTokenTable);         //3d
        register(IntToBool.class, mainTokenTable);         //3e
        register(IntToFloat.class, mainTokenTable);        //3f
        register(BoolToByte.class, mainTokenTable);        //40
        register(Remove.class, mainTokenTable);            //41
        register(BoolToFloat.class, mainTokenTable);       //42
        register(FloatToByte.class, mainTokenTable);       //43
        register(FloatToInt.class, mainTokenTable);        //44
        register(FloatToBool.class, mainTokenTable);       //45


        register(StringToInt.class, mainTokenTable);       //4a
        register(StringToBool.class, mainTokenTable);      //4b
        register(StringToFloat.class, mainTokenTable);     //4c
        register(StringToVector.class, mainTokenTable);    //4d
        register(StringToRotator.class, mainTokenTable);   //4e
        register(VectorToBool.class, mainTokenTable);      //4f
        register(VectorToRotator.class, mainTokenTable);   //50
        register(RotatorToBool.class, mainTokenTable);     //51
        register(ByteToString.class, mainTokenTable);      //52
        register(IntToString.class, mainTokenTable);       //53
        register(BoolToString.class, mainTokenTable);      //54
        register(FloatToString.class, mainTokenTable);     //55
        register(ObjectToString.class, mainTokenTable);    //56
        register(NameToString.class, mainTokenTable);      //57
        register(VectorToString.class, mainTokenTable);    //58
        register(RotatorToString.class, mainTokenTable);   //59

        conversionTokenTable.putAll(mainTokenTable);
        register(BoolToInt.class, conversionTokenTable);         //41
        register(IntToINT64.class, conversionTokenTable);        //5b
        register(BoolToINT64.class, conversionTokenTable);       //5c
        register(StringToINT64.class, conversionTokenTable);     //5e
        register(INT64ToInt.class, conversionTokenTable);        //60
        register(INT64ToFloat.class, conversionTokenTable);      //62
        register(INT64ToString.class, conversionTokenTable);     //63
    }

    static void register(Class<? extends Token> clazz, Map<Integer, Method> map) {
        try {
            map.put(clazz.getDeclaredField("OPCODE").getInt(null), clazz.getDeclaredMethod("readFrom", BytecodeInput.class));
        } catch (ReflectiveOperationException e) {
            log.log(Level.WARNING, e, () -> String.format("Couldn't register %s opcode", clazz));
        }
    }
}

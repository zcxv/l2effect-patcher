package acmi.l2.clientmod.unreal;

public class UnrealException extends RuntimeException {
    public UnrealException(String message) {
        super(message);
    }

    public UnrealException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnrealException(Throwable cause) {
        super(cause);
    }
}

package dream.exception;

public class ChanceException extends RuntimeException {
    public ChanceException() {
    }

    public ChanceException(String message) {
        super(message);
    }

    public ChanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChanceException(Throwable cause) {
        super(cause);
    }

    public ChanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

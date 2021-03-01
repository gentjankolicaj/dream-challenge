package dream.exception;

public class ChoiceException extends RuntimeException {
    public ChoiceException() {
    }

    public ChoiceException(String message) {
        super(message);
    }

    public ChoiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChoiceException(Throwable cause) {
        super(cause);
    }

    public ChoiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

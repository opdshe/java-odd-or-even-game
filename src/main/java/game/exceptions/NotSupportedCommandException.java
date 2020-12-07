package game.exceptions;

public class NotSupportedCommandException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 입력은 1또는 2만 허용됩니다. ";

    public NotSupportedCommandException() {
        super(MESSAGE);
    }
}

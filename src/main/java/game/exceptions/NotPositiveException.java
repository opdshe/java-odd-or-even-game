package game.exceptions;

public class NotPositiveException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 입력값은 1이상이어야 합니다. ";

    public NotPositiveException() {
        super(MESSAGE);
    }
}

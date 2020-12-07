package game.exceptions;

public class NotNumericException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 입력값이 정수형이 아닙니다. ";

    public NotNumericException() {
        super(MESSAGE);
    }
}

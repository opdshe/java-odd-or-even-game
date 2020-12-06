package game.exceptions;

public class TooLongPlayerNameException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 사용자 이름은 최대 5글자까지만 허용됩니다. ";

    public TooLongPlayerNameException() {
        super(MESSAGE);
    }
}

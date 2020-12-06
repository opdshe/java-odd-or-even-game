package game.exceptions;

public class CompletelyBlankPlayerNamesException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 사용자 이름으로 개행문자가 입력되었습니다. ";

    public CompletelyBlankPlayerNamesException() {
        super(MESSAGE);
    }
}

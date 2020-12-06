package game.exceptions;

public class PartiallyBlankPlayerNamesException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 사용자 이름으로 공백이 입력되었습니다. ";

    public PartiallyBlankPlayerNamesException() {
        super(MESSAGE);
    }
}

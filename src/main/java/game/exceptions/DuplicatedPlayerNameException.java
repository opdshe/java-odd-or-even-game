package game.exceptions;

public class DuplicatedPlayerNameException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 상대방 이름과 사용자 이름이 중복됩니다. ";

    public DuplicatedPlayerNameException() {
        super(MESSAGE);
    }
}

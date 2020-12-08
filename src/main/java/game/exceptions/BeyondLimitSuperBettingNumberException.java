package game.exceptions;

import game.domain.TargetNumber;

public class BeyondLimitSuperBettingNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 슈퍼 베팅 넘버는 " + TargetNumber.MIN_VALUE + "~" + TargetNumber.MAX_VALUE +
            "사이로 입력해 주세요.";

    public BeyondLimitSuperBettingNumberException() {
        super(MESSAGE);
    }
}

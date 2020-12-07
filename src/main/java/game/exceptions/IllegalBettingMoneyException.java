package game.exceptions;

import game.domain.BettingMoney;

public class IllegalBettingMoneyException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 금액은 " + BettingMoney.MONEY_UNIT + "단위로 입력해 주세요.";

    public IllegalBettingMoneyException() {
        super(MESSAGE);
    }
}

package game.exceptions;

public class OverBalanceBettingMoneyException extends IllegalArgumentException {
    private static final String MESSAGE = "[ERROR] 베팅금액이 잔고보다 많습니다. ";

    public OverBalanceBettingMoneyException() {
        super(MESSAGE);
    }
}

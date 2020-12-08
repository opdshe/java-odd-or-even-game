package game.domain;

public class Result {
    public enum ResultFlag {
        WIN, LOSE;
    }

    private final BettingMoney bettingMoney;
    private final ResultFlag resultFlag;

    public Result(BettingMoney bettingMoney, ResultFlag resultFlag) {
        this.bettingMoney = bettingMoney;
        this.resultFlag = resultFlag;
    }

    public boolean isWin() {
        return resultFlag == (ResultFlag.WIN);
    }

    public BettingMoney getBettingMoney() {
        return bettingMoney;
    }
}

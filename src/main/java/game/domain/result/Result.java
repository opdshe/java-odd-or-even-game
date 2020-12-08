package game.domain.result;

public class Result {
    public enum ResultFlag {
        WIN, LOSE;
    }

    private final int bettingMoney;
    private final ResultFlag resultFlag;

    public Result(int bettingMoney, ResultFlag resultFlag) {
        this.bettingMoney = bettingMoney;
        this.resultFlag = resultFlag;
    }

    public boolean isWin() {
        return resultFlag == (ResultFlag.WIN);
    }

    public int getBettingMoney() {
        return bettingMoney;
    }
}

package game.domain.result;

public class NormalModeResult extends Result {
    private int bettingMoney;

    public NormalModeResult(int bettingMoney, ResultFlag resultFlag) {
        super(resultFlag);
        this.bettingMoney = bettingMoney;
    }

    public int getBettingMoney() {
        return bettingMoney;
    }
}

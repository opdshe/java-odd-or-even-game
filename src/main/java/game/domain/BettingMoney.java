package game.domain;

public class BettingMoney {
    public static final int MONEY_UNIT = 1000;

    private final int money;

    public BettingMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}

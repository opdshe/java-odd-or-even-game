package game.domain.player;

public class Player {
    public static final int MAX_LENGTH_OF_PLAYER_NAME = 5;
    private static final int INITIAL_BALANCE = 10000;
    private static final int ZERO = 0;
    private static final int TWO = 2;

    private final String name;
    private int balance;

    public Player(String name) {
        this.name = name;
        this.balance = INITIAL_BALANCE;
    }

    public void win(int bettingMoney) {
        balance += bettingMoney;
    }

    public void lose(int bettingMoney) {
        balance -= bettingMoney;
    }

    public boolean isAvailableBettingMoney(int bettingMoney) {
        return balance >= bettingMoney;
    }

    public boolean isBankrupt() {
        return balance <= ZERO;
    }

    public int getBalance() {
        return balance;
    }

    public int getHalfOfBalance() {
        return balance / TWO;
    }
}

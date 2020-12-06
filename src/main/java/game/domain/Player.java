package game.domain;

public class Player {
    public static final int MAX_LENGTH_OF_PLAYER_NAME = 5;
    private static final int INITIAL_BALANCE = 10000;

    private final String name;
    private int balance;

    public Player(String name) {
        this.name = name;
        this.balance = INITIAL_BALANCE;
    }
}

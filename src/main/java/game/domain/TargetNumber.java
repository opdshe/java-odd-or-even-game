package game.domain;

public class TargetNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 10;

    private final int number;

    public TargetNumber(int number) {
        this.number = number;
    }
}

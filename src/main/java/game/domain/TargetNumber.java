package game.domain;

import game.domain.oddoreven.OddOrEven;

public class TargetNumber {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 10;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    private final int number;

    public TargetNumber(int number) {
        this.number = number;
    }

    public boolean isRightOddOrEven(OddOrEven oddOrEven) {
        return getTargetOddOrEven().equals(oddOrEven);
    }

    private OddOrEven getTargetOddOrEven() {
        if (number % TWO == ZERO) {
            return OddOrEven.EVEN;
        }
        return OddOrEven.ODD;
    }

    public boolean isRightSuperBettingNumber(int superBettingNumber) {
        return number == superBettingNumber;
    }
}

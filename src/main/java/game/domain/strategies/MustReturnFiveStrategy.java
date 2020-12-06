package game.domain.strategies;

public class MustReturnFiveStrategy implements NumberGeneratingStrategy {
    private static final int FIVE = 5;

    @Override
    public int generate() {
        return FIVE;
    }
}

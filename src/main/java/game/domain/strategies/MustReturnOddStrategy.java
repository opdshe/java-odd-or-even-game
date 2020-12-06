package game.domain.strategies;

public class MustReturnOddStrategy implements NumberGeneratingStrategy {
    private static final int ODD_NUMBER = 1;

    @Override
    public int generate() {
        return ODD_NUMBER;
    }
}

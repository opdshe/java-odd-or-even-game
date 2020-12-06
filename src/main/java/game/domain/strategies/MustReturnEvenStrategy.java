package game.domain.strategies;

public class MustReturnEvenStrategy implements NumberGeneratingStrategy {
    private static final int EVEN_NUMBER = 2;

    @Override
    public int generate() {
        return EVEN_NUMBER;
    }
}

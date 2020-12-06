package game.domain.strategies;

import game.domain.TargetNumber;
import utils.RandomUtils;

public class RandomNumberStrategy implements NumberGeneratingStrategy {
    @Override
    public int generate() {
        return RandomUtils.nextInt(TargetNumber.MIN_VALUE, TargetNumber.MAX_VALUE);
    }
}

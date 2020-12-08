package game.domain.strategies;

import game.domain.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultCreatorTest {
    @Test
    public void 홀짝_맞힌경우_확인() {
        //given
        TargetNumber targetNumber = new TargetNumber(2);
        BettingMoney bettingMoney = new BettingMoney(1000);
        OddOrEven oddOrEven = OddOrEven.EVEN;

        //when
        Result result = ResultCreator.createResult(targetNumber, bettingMoney, oddOrEven);

        //then
        assertThat(result.isWin()).isTrue();
    }

    @Test
    public void 홀짝_틀린경우_확인() {
        //given
        TargetNumber targetNumber = new TargetNumber(2);
        BettingMoney bettingMoney = new BettingMoney(1000);
        OddOrEven oddOrEven = OddOrEven.ODD;

        //when
        Result result = ResultCreator.createResult(targetNumber, bettingMoney, oddOrEven);

        //then
        assertThat(result.isWin()).isFalse();
    }
}
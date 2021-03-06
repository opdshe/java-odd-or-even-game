package game.domain.strategies;

import game.domain.BettingMoney;
import game.domain.TargetNumber;
import game.domain.oddoreven.OddOrEven;
import game.domain.result.Result;
import game.domain.result.ResultCreator;
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
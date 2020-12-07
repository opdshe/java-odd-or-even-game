package game.validators;

import game.domain.Player;
import game.exceptions.IllegalBettingMoneyException;
import game.exceptions.NotNumericException;
import game.exceptions.NotPositiveException;
import game.exceptions.OverBalanceBettingMoneyException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BettingMoneyValidatorTest {
    private Player user = new Player("heon");

    @Test
    public void 올바른_입력시_예외_발생_안함() {
        //given
        String bettingMoney = "1000";

        //when & then
        assertDoesNotThrow(() -> BettingMoneyValidator.validateBettingMoney(user, bettingMoney));
    }

    @Test
    public void 정수형이_아닌_입력값_입력시_예외_발생() {
        //given
        String hangulBettingMoney = "천원";
        String floatBettingMoney = "3000.534";

        //when & then
        assertThatExceptionOfType(NotNumericException.class)
                .isThrownBy(() -> BettingMoneyValidator.validateBettingMoney(user, hangulBettingMoney));
        assertThatExceptionOfType(NotNumericException.class)
                .isThrownBy(() -> BettingMoneyValidator.validateBettingMoney(user, floatBettingMoney));
    }

    @Test
    public void 양수가_아닌_입력값_입력시_예외_발생() {
        //given
        String notPositiveBettingMoney = "0";

        //when & then
        assertThatExceptionOfType(NotPositiveException.class)
                .isThrownBy(() -> BettingMoneyValidator.validateBettingMoney(user, notPositiveBettingMoney));
    }

    @Test
    public void 천단위_아닌_입력값_입력시_예외_발생() {
        //given
        String bettingMoney = "1500";

        //when & then
        assertThatExceptionOfType(IllegalBettingMoneyException.class)
                .isThrownBy(() -> BettingMoneyValidator.validateBettingMoney(user, bettingMoney));
    }

    @Test
    public void 잔고보다_많은_배팅금액_입력시_예외_발생() {
        //given
        String bettingMoney = "20000";

        //when & then
        assertThatExceptionOfType(OverBalanceBettingMoneyException.class)
                .isThrownBy(() -> BettingMoneyValidator.validateBettingMoney(user, bettingMoney));
    }
}
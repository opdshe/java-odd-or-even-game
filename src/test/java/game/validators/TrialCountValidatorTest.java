package game.validators;

import game.exceptions.NotNumericTrialCountException;
import game.exceptions.NotPositiveTrialCountException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TrialCountValidatorTest {
    @Test
    public void 올바른_시도횟수_입력시_예외_발생_안함() {
        //given
        String trialCount = "1";

        //when & then
        assertDoesNotThrow(() -> TrialCountValidator.validateTrialCount(trialCount));
    }

    @Test
    public void 정수형이_아닌_입력시_예외_발생() {
        //given
        String hangulTrialCount = "한번";
        String floatTrialCount = "3.4";

        //when & then
        assertThatExceptionOfType(NotNumericTrialCountException.class)
                .isThrownBy(() -> TrialCountValidator.validateTrialCount(hangulTrialCount));
        assertThatExceptionOfType(NotNumericTrialCountException.class)
                .isThrownBy(() -> TrialCountValidator.validateTrialCount(floatTrialCount));
    }

    @Test
    public void 양수가_아닌_입력시_예외_발생() {
        //given
        String trialCount = "0";

        //when & then
        assertThatExceptionOfType(NotPositiveTrialCountException.class)
                .isThrownBy(() -> TrialCountValidator.validateTrialCount(trialCount));
    }
}
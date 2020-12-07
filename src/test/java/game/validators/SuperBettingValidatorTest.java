package game.validators;

import game.exceptions.NotSupportedCommandException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SuperBettingValidatorTest {
    @Test
    public void 올바른_입력시_예외_발생안함() {
        //given
        String one = "1";
        String two = "2";

        //when & then
        assertDoesNotThrow(() -> SuperBettingValidator.validateSuperBetting(one));
        assertDoesNotThrow(() -> SuperBettingValidator.validateSuperBetting(two));
    }

    @Test
    public void 지원하지_않는_입력값_입력시_예외_발생() {
        //given
        String notSupportedCommand = "이번";

        //when & then
        assertThatExceptionOfType(NotSupportedCommandException.class)
                .isThrownBy(() -> SuperBettingValidator.validateSuperBetting(notSupportedCommand));
    }
}
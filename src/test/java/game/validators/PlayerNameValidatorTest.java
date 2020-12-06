package game.validators;

import game.exceptions.CompletelyBlankPlayerNamesException;
import game.exceptions.DuplicatedPlayerNameException;
import game.exceptions.PartiallyBlankPlayerNamesException;
import game.exceptions.TooLongPlayerNameException;
import org.junit.Test;
import utils.StringConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerNameValidatorTest {
    @Test
    public void 올바른_이름_입력시_예외_발생안함() {
        //given
        String rawPlayerNames = "fobi, heon";
        List<String> playerNames = StringConverter.toListSplitByComma(rawPlayerNames);

        //when & then
        PlayerNameValidator.validatePlayerNames(playerNames);
    }

    @Test
    public void 개행문자_입력시_예외_발생() {
        //given
        String rawPlayerNames = "\n";
        List<String> playerNames = StringConverter.toListSplitByComma(rawPlayerNames);

        //when & then
        assertThatExceptionOfType(CompletelyBlankPlayerNamesException.class)
                .isThrownBy(() -> PlayerNameValidator.validatePlayerNames(playerNames));
    }

    @Test
    public void 이름으로_공백_입력시_예외_발생() {
        //given
        String rawPlayerNames = "heon, ";
        List<String> playerNames = StringConverter.toListSplitByComma(rawPlayerNames);

        //when & then
        assertThatExceptionOfType(PartiallyBlankPlayerNamesException.class)
                .isThrownBy(() -> PlayerNameValidator.validatePlayerNames(playerNames));
    }

    @Test
    public void 중복되는_이름_입력시_예외_발생() {
        //given
        String rawPlayerNames = "heon, heon";
        List<String> playerNames = StringConverter.toListSplitByComma(rawPlayerNames);

        //when & then
        assertThatExceptionOfType(DuplicatedPlayerNameException.class)
                .isThrownBy(() -> PlayerNameValidator.validatePlayerNames(playerNames));
    }

    @Test
    public void 최대길이보다_긴_이름_입력시_예외_발생() {
        //given
        String rawPlayerNames = "dongheon, fobi";
        List<String> playerNames = StringConverter.toListSplitByComma(rawPlayerNames);

        //when & then
        assertThatExceptionOfType(TooLongPlayerNameException.class)
                .isThrownBy(() -> PlayerNameValidator.validatePlayerNames(playerNames));
    }
}
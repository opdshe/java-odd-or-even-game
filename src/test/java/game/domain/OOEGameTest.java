package game.domain;

import game.domain.ooegame.OOEGame;
import game.domain.ooegame.OOEGameCreator;
import game.domain.strategies.MustReturnOddStrategy;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OOEGameTest {
    @Test
    public void 사용자가_이겼을때_자금_상태_확인() {
        List<String> playerNames = Arrays.asList("fobi", "heon");
        int bettingMoney = 1000;
        OOEGame ooeGame = OOEGameCreator.createOOEGame(playerNames, new MustReturnOddStrategy());

        //when
        ooeGame.winNormalMode(bettingMoney);

        //then
        int balance = ooeGame.getUser().getBalance();
        assertThat(balance).isEqualTo(11000);
    }

    @Test
    public void 사용자가_졌을때_자금_상태_확인() {
        List<String> playerNames = Arrays.asList("fobi", "heon");
        int bettingMoney = 1000;
        OOEGame ooeGame = OOEGameCreator.createOOEGame(playerNames, new MustReturnOddStrategy());

        //when
        ooeGame.loseNormalMode(bettingMoney);

        //then
        int balance = ooeGame.getUser().getBalance();
        assertThat(balance).isEqualTo(9000);
    }
}
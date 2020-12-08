package game.domain.ooegame;

import game.domain.player.Player;
import game.domain.player.PlayerCreator;
import game.domain.strategies.NumberGeneratingStrategy;

import java.util.List;

public class OOEGameCreator {
    private static final int COMPUTER_INDEX = 0;
    private static final int USER_INDEX = 1;

    private OOEGameCreator() {
    }

    public static OOEGame createOOEGame(List<String> playerNames, NumberGeneratingStrategy generatingStrategy) {
        Player computer = PlayerCreator.createPlayer(playerNames.get(COMPUTER_INDEX));
        Player user = PlayerCreator.createPlayer(playerNames.get(USER_INDEX));
        return new OOEGame(computer, user, generatingStrategy);
    }
}

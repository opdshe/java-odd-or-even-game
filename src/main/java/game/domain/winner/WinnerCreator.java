package game.domain.winner;

import game.domain.ooegame.OOEGame;
import game.domain.player.Player;

public class WinnerCreator {
    private WinnerCreator() {
    }

    public static Winner createWinner(OOEGame ooeGame) {
        Player computer = ooeGame.getComputer();
        Player user = ooeGame.getUser();
        return selectWinner(computer, user);
    }

    private static Winner selectWinner(Player computer, Player user) {
        if (computer.getBalance() > user.getBalance()) {
            return new Winner(computer.getName(), computer.getProfit());
        }
        return new Winner(user.getName(), user.getProfit());
    }
}

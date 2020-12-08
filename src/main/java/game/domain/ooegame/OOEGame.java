package game.domain.ooegame;

import game.domain.Status;
import game.domain.TargetNumber;
import game.domain.player.Player;
import game.domain.strategies.NumberGeneratingStrategy;

public class OOEGame {
    private final NumberGeneratingStrategy generatingStrategy;
    private final Player computer;
    private final Player user;

    public OOEGame(Player computer, Player user, NumberGeneratingStrategy generatingStrategy) {
        this.computer = computer;
        this.user = user;
        this.generatingStrategy = generatingStrategy;
    }

    public TargetNumber createTargetNumber() {
        return new TargetNumber(this.generatingStrategy.generate());
    }

    public void winNormalMode(int bettingMoney) {
        user.win(bettingMoney);
        computer.lose(bettingMoney);
    }

    public void loseNormalMode(int bettingMoney) {
        user.lose(bettingMoney);
        computer.win(bettingMoney);
    }

    public void winSuperBettingMode() {
        int money = computer.getBalance();
        user.win(money);
        computer.lose(money);
    }

    public void loseSuperBettingMode() {
        int money = user.getHalfOfBalance();
        user.win(money);
        computer.lose(money);
    }

    public void terminateIfAnyoneBankrupt(Status status) {
        if (isAnyoneBankrupt()) {
            status.terminate();
        }
    }

    private boolean isAnyoneBankrupt() {
        return computer.isBankrupt() || user.isBankrupt();
    }

    public Player getUser() {
        return user;
    }

    public Player getComputer() {
        return computer;
    }
}

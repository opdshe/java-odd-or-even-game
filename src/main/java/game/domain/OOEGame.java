package game.domain;

import game.domain.strategies.NumberGeneratingStrategy;

public class OOEGame {
    private NumberGeneratingStrategy generatingStrategy;
    private Player computer;
    private Player user;

    public OOEGame(Player computer, Player user, NumberGeneratingStrategy generatingStrategy) {
        this.computer = computer;
        this.user = user;
        this.generatingStrategy = generatingStrategy;
    }

    public TargetNumber createTargetNumber() {
        return new TargetNumber(this.generatingStrategy.generate());
    }

    public void win(BettingMoney bettingMoney) {
        user.win(bettingMoney);
        computer.lose(bettingMoney);
    }

    public void lose(BettingMoney bettingMoney) {
        user.lose(bettingMoney);
        computer.win(bettingMoney);
    }

    public Player getUser() {
        return user;
    }
}

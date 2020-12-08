package game.domain.winner;

public class Winner {
    private final String name;
    private final int profit;

    public Winner(String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }
}

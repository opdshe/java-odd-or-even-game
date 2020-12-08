package game.views;

import game.domain.result.NormalModeResult;
import game.domain.result.SuperBettingModeResult;
import game.domain.winner.Winner;

public class OutputView {
    private static final String CORRECT_MESSAGE = "정답입니다. ";
    private static final String WRONG_MESSAGE = "틀렸습니다. ";
    private static final String OBTAIN_MONEY_MESSAGE = "원을 획득했습니다. ";
    private static final String LOSE_MONEY_MESSAGE = "원을 잃었습니다. ";
    private static final String WIN = "가 승리하엿습니다. ";
    private static final String PROFIT_IS = "최종 수익은";

    private OutputView() {
    }

    public static void printNormalResultMessage(NormalModeResult result) {
        if (result.isWin()) {
            printNormalModeWinMessage(result);
            return;
        }
        printNormalModeLoseMessage(result);
    }

    private static void printNormalModeWinMessage(NormalModeResult result) {
        int money = result.getBettingMoney();
        printMessageAndNewLine(CORRECT_MESSAGE + money + OBTAIN_MONEY_MESSAGE);
    }

    private static void printNormalModeLoseMessage(NormalModeResult result) {
        int money = result.getBettingMoney();
        printMessageAndNewLine(WRONG_MESSAGE + money + LOSE_MONEY_MESSAGE);
    }

    public static void printSuperBettingResultMessage(SuperBettingModeResult result) {
        if (result.isWin()) {
            printMessageAndNewLine(CORRECT_MESSAGE);
            return;
        }
        printMessageAndNewLine(WRONG_MESSAGE);
    }

    public static void printWinner(Winner winner) {
        OutputView.printMessageAndNewLine(winner.getName() + WIN + PROFIT_IS + winner.getProfit());
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}

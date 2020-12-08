package game.views;

import game.domain.result.Result;

public class OutputView {
    private static final String WIN_MESSAGE = "정답입니다. ";
    private static final String LOSE_MESSAGE = "틀렸습니다. ";
    private static final String OBTAIN_MONEY_MESSAGE = "원을 획득했습니다. ";
    private static final String LOSE_MONEY_MESSAGE = "원을 잃었습니다. ";

    private OutputView() {
    }

    public static void printResultMessage(Result result) {
        if (result.isWin()) {
            printWinMessage(result);
            return;
        }
        printLoseMessage(result);
    }

    private static void printWinMessage(Result result) {
        int money = result.getBettingMoney();
        printMessageAndNewLine(WIN_MESSAGE + money + OBTAIN_MONEY_MESSAGE);
    }

    private static void printLoseMessage(Result result) {
        int money = result.getBettingMoney();
        printMessageAndNewLine(LOSE_MESSAGE + money + LOSE_MONEY_MESSAGE);
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}

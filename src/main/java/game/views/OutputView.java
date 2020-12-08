package game.views;

import game.domain.result.NormalModeResult;
import game.domain.result.SuperBettingModeResult;

public class OutputView {
    private static final String WIN_MESSAGE = "정답입니다. ";
    private static final String LOSE_MESSAGE = "틀렸습니다. ";
    private static final String OBTAIN_MONEY_MESSAGE = "원을 획득했습니다. ";
    private static final String LOSE_MONEY_MESSAGE = "원을 잃었습니다. ";

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
        printMessageAndNewLine(WIN_MESSAGE + money + OBTAIN_MONEY_MESSAGE);
    }

    private static void printNormalModeLoseMessage(NormalModeResult result) {
        int money = result.getBettingMoney();
        printMessageAndNewLine(LOSE_MESSAGE + money + LOSE_MONEY_MESSAGE);
    }

    public static void printSuperBettingResultMessage(SuperBettingModeResult result) {
        if (result.isWin()) {
            printMessageAndNewLine(WIN_MESSAGE);
            return;
        }
        printMessageAndNewLine(LOSE_MESSAGE);
    }

    public static void printMessageAndNewLine(String message) {
        System.out.println(message);
    }
}

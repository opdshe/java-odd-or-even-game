package game.domain;

import game.views.InputView;

import java.util.Scanner;

public class OOEGameController {
    private static void playOneRound(OOEGame ooeGame, Scanner scanner) {
        boolean supplerBettingFlag = InputView.inputSuperBettingFlag(scanner);
        if (isNormalTurn(supplerBettingFlag)) {
            playNormalTurn(ooeGame, scanner);
            return;
        }
        playSuperBettingTurn();
    }

    private static void playNormalTurn(OOEGame ooeGame, Scanner scanner) {
        TargetNumber targetNumber = ooeGame.createTargetNumber();
        BettingMoney bettingMoney = InputView.inputBettingMoney(ooeGame.getUser(), scanner);
    }

    private static boolean isNormalTurn(boolean supperBettingFlag) {
        return !supperBettingFlag;
    }

    private static void playSuperBettingTurn() {

    }
}

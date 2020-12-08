package game.domain.ooegame;

import game.domain.BettingMoney;
import game.domain.TargetNumber;
import game.domain.oddoreven.OddOrEven;
import game.domain.result.Result;
import game.domain.result.ResultCreator;
import game.views.InputView;
import game.views.OutputView;

import java.util.Scanner;

public class OOEGameController {
    public static void playOneRound(OOEGame ooeGame, Scanner scanner) {
        boolean superBettingFlag = InputView.inputSuperBettingFlag(scanner);
        if (isNormalMode(superBettingFlag)) {
            playNormalMode(ooeGame, scanner);
            return;
        }
        playSuperBettingTurn();
    }

    private static boolean isNormalMode(boolean superBettingFlag) {
        return !superBettingFlag;
    }

    private static void playNormalMode(OOEGame ooeGame, Scanner scanner) {
        TargetNumber targetNumber = ooeGame.createTargetNumber();
        BettingMoney bettingMoney = InputView.inputBettingMoney(ooeGame.getUser(), scanner);
        OddOrEven oddOrEven = InputView.inputOddOrEven(scanner);
        Result result = ResultCreator.createResult(targetNumber, bettingMoney, oddOrEven);
        proceedNormalModeResult(ooeGame, result);
    }

    private static void proceedNormalModeResult(OOEGame ooeGame, Result result) {
        OutputView.printResultMessage(result);
        if (result.isWin()) {
            ooeGame.win(result.getBettingMoney());
            return;
        }
        ooeGame.lose(result.getBettingMoney());
    }

    private static void playSuperBettingTurn() {

    }
}

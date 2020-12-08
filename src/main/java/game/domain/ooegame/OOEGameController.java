package game.domain.ooegame;

import game.domain.BettingMoney;
import game.domain.Status;
import game.domain.TargetNumber;
import game.domain.oddoreven.OddOrEven;
import game.domain.result.NormalModeResult;
import game.domain.result.ResultCreator;
import game.domain.result.SuperBettingModeResult;
import game.views.InputView;
import game.views.OutputView;

import java.util.Scanner;

public class OOEGameController {
    public static void playOneRound(OOEGame ooeGame, Status status, Scanner scanner) {
        TargetNumber targetNumber = ooeGame.createTargetNumber();
        boolean superBettingFlag = InputView.inputSuperBettingFlag(scanner);
        if (isNormalMode(superBettingFlag)) {
            playNormalMode(ooeGame, targetNumber, scanner);
            ooeGame.terminateIfAnyoneBankrupt(status);
            return;
        }
        playSuperBettingMode(ooeGame, targetNumber, scanner);
        ooeGame.terminateIfAnyoneBankrupt(status);
    }

    private static boolean isNormalMode(boolean superBettingFlag) {
        return !superBettingFlag;
    }

    private static void playNormalMode(OOEGame ooeGame, TargetNumber targetNumber, Scanner scanner) {
        BettingMoney bettingMoney = InputView.inputBettingMoney(ooeGame.getUser(), scanner);
        OddOrEven oddOrEven = InputView.inputOddOrEven(scanner);
        NormalModeResult result = ResultCreator.createNormalResult(targetNumber, bettingMoney, oddOrEven);
        proceedNormalModeResult(ooeGame, result);
    }

    private static void proceedNormalModeResult(OOEGame ooeGame, NormalModeResult result) {
        OutputView.printNormalResultMessage(result);
        if (result.isWin()) {
            ooeGame.winNormalMode(result.getBettingMoney());
            return;
        }
        ooeGame.loseNormalMode(result.getBettingMoney());
    }

    private static void playSuperBettingMode(OOEGame ooeGame, TargetNumber targetNumber, Scanner scanner) {
        int superBettingNumber = InputView.inputSuperBettingNumber(scanner);
        SuperBettingModeResult result = ResultCreator.createSuperBettingModeResult(targetNumber, superBettingNumber);
        proceedSuperBettingModeResult(ooeGame, result);
    }

    private static void proceedSuperBettingModeResult(OOEGame ooeGame, SuperBettingModeResult result) {
        OutputView.printSuperBettingResultMessage(result);
        if (result.isWin()) {
            ooeGame.winSuperBettingMode();
            return;
        }
        ooeGame.loseSuperBettingMode();
    }
}

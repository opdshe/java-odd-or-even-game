package game;

import game.domain.Status;
import game.domain.ooegame.OOEGame;
import game.domain.ooegame.OOEGameController;
import game.domain.ooegame.OOEGameCreator;
import game.domain.strategies.RandomNumberStrategy;
import game.domain.winner.Winner;
import game.domain.winner.WinnerCreator;
import game.views.InputView;
import game.views.OutputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        playOOEGame(scanner);
    }

    private static void playOOEGame(Scanner scanner) {
        List<String> playerNames = InputView.inputPlayerNames(scanner);
        int trialCount = InputView.inputTrialCount(scanner);

        OOEGame ooeGame = OOEGameCreator.createOOEGame(playerNames, new RandomNumberStrategy());
        playAsManyAsTrialCount(ooeGame, trialCount, scanner);
        selectAndPrintWinner(ooeGame);
    }

    private static void playAsManyAsTrialCount(OOEGame ooeGame, int trialCount, Scanner scanner) {
        Status status = new Status(Status.State.CONTINUE);
        do {
            OOEGameController.playOneRound(ooeGame, status, scanner);
            OutputView.printCurrentStatus(ooeGame);
            trialCount--;
        } while (status.isContinue() && trialCount > 0);
    }

    private static void selectAndPrintWinner(OOEGame ooeGame) {
        Winner winner = WinnerCreator.createWinner(ooeGame);
        OutputView.printWinner(winner);
    }
}

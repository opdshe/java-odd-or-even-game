package game;

import game.domain.OOEGame;
import game.domain.OOEGameCreator;
import game.domain.strategies.RandomNumberStrategy;
import game.views.InputView;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        play(scanner);
    }

    private static void play(Scanner scanner) {
        List<String> playerNames = InputView.inputPlayerNames(scanner);
        int count = InputView.inputTrialCount(scanner);

        OOEGame ooeGame = OOEGameCreator.createOOEGame(playerNames, new RandomNumberStrategy());
    }
}

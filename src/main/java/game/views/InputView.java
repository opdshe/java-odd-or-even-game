package game.views;

import game.validators.PlayerNameValidator;
import game.validators.TrialCountValidator;
import utils.StringConverter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAMES = "상대방과 사용자의 이름을 입력해 주세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 횟수는 몇 회인가요?";

    private InputView() {
    }

    public static List<String> inputPlayerNames(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_PLAYER_NAMES);
        List<String> playerNames = StringConverter.toListSplitByComma(scanner.nextLine());
        try {
            PlayerNameValidator.validatePlayerNames(playerNames);
            return playerNames;
        } catch (IllegalArgumentException exception) {
            OutputView.printMessageAndNewLine(exception.getMessage());
            return inputPlayerNames(scanner);
        }
    }

    public static int inputTrialCount(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_TRIAL_COUNT);
        String trialCount = scanner.nextLine();
        try {
            TrialCountValidator.validateTrialCount(trialCount);
            return Integer.parseInt(trialCount);
        } catch (IllegalArgumentException exception) {
            OutputView.printMessageAndNewLine(exception.getMessage());
            return inputTrialCount(scanner);
        }
    }
}

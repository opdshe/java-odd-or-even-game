package game.views;

import game.domain.BettingMoney;
import game.domain.SuperBettingMapper;
import game.validators.BettingMoneyValidator;
import game.validators.PlayerNameValidator;
import game.validators.SuperBettingValidator;
import game.validators.TrialCountValidator;
import utils.StringConverter;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAMES = "상대방과 사용자의 이름을 입력해 주세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIAL_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String INPUT_SUPER_BETTING_FLAG = "슈퍼베팅을 사용하시겠습니까? 사용: 1, 미사용 :2";
    private static final String INPUT_BETTING_MONEY = "베팅 금액을 입력해 주세요. 금액은 1000단위로 입력 가능합니다. ";

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

    public static boolean inputSuperBettingFlag(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_SUPER_BETTING_FLAG);
        String superBettingFlag = scanner.nextLine();
        try {
            SuperBettingValidator.validateSuperBetting(superBettingFlag);
            return SuperBettingMapper.getSuperBettingFlag(superBettingFlag);
        } catch (IllegalArgumentException exception) {
            return inputSuperBettingFlag(scanner);
        }
    }

    public static BettingMoney inputBettingMoney(Scanner scanner) {
        OutputView.printMessageAndNewLine(INPUT_BETTING_MONEY);
        String bettingMoney = scanner.nextLine();
        try {
            BettingMoneyValidator.validateBettingMoney(bettingMoney);
            return new BettingMoney(Integer.parseInt(bettingMoney));
        } catch (IllegalArgumentException exception) {
            OutputView.printMessageAndNewLine(exception.getMessage());
            return inputBettingMoney(scanner);
        }
    }
}

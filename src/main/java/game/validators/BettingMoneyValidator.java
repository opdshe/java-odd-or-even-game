package game.validators;

import game.domain.BettingMoney;
import game.domain.player.Player;
import game.exceptions.IllegalBettingMoneyException;
import game.exceptions.NotNumericException;
import game.exceptions.NotPositiveException;
import game.exceptions.OverBalanceBettingMoneyException;

public class BettingMoneyValidator {
    private static final int ZERO = 0;

    private BettingMoneyValidator() {
    }

    public static void validateBettingMoney(Player user, String bettingMoney) {
        validateNumeric(bettingMoney);
        validatePositive(bettingMoney);
        validateMoneyUnit(bettingMoney);
        validateBalance(user, bettingMoney);
    }

    private static void validateNumeric(String bettingMoney) {
        if (!isNumeric(bettingMoney)) {
            throw new NotNumericException();
        }
    }

    private static boolean isNumeric(String bettingMoney) {
        try {
            Integer.parseInt(bettingMoney);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static void validatePositive(String bettingMoney) {
        if (!isPositive(bettingMoney)) {
            throw new NotPositiveException();
        }
    }

    private static boolean isPositive(String bettingMoney) {
        return Integer.parseInt(bettingMoney) > ZERO;
    }

    private static void validateMoneyUnit(String bettingMoney) {
        if (!isAvailableBettingMoney(bettingMoney)) {
            throw new IllegalBettingMoneyException();
        }
    }

    private static boolean isAvailableBettingMoney(String bettingMoney) {
        return Integer.parseInt(bettingMoney) % BettingMoney.MONEY_UNIT == ZERO;
    }

    private static void validateBalance(Player user, String bettingMoney) {
        if (!user.isAvailableBettingMoney(Integer.parseInt(bettingMoney))) {
            throw new OverBalanceBettingMoneyException();
        }
    }
}

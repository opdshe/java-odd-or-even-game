package game.validators;

import game.domain.TargetNumber;
import game.exceptions.BeyondLimitSuperBettingNumberException;
import game.exceptions.NotNumericException;

public class SuperBettingNumberValidator {
    private SuperBettingNumberValidator() {
    }

    public static void validateSuperBettingNumber(String superBettingNumber) {
        validateNumeric(superBettingNumber);
        validateRange(superBettingNumber);
    }

    private static void validateNumeric(String superBettingNumber) {
        if (!isNumeric(superBettingNumber)) {
            throw new NotNumericException();
        }
    }

    private static boolean isNumeric(String superBettingNumber) {
        try {
            Integer.parseInt(superBettingNumber);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    private static void validateRange(String superBettingNumber) {
        if (isBeyondLimit(superBettingNumber)) {
            throw new BeyondLimitSuperBettingNumberException();
        }
    }

    private static boolean isBeyondLimit(String superBettingNumber) {
        return Integer.parseInt(superBettingNumber) < TargetNumber.MIN_VALUE ||
                Integer.parseInt(superBettingNumber) > TargetNumber.MAX_VALUE;
    }
}

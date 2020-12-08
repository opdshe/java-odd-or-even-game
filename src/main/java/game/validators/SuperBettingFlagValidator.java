package game.validators;

import game.exceptions.NotSupportedCommandException;

import java.util.HashSet;
import java.util.Set;

public class SuperBettingFlagValidator {
    private static final String USE_SUPER_BETTING = "1";
    private static final String NOT_USE_SUPER_BETTING = "2";

    private static final Set<String> commands = new HashSet<>();

    static {
        commands.add(USE_SUPER_BETTING);
        commands.add(NOT_USE_SUPER_BETTING);
    }

    public static void validateSuperBetting(String superBettingFlag) {
        if (!isAvailableCommand(superBettingFlag)) {
            throw new NotSupportedCommandException();
        }
    }

    private static boolean isAvailableCommand(String superBettingFlag) {
        return commands.contains(superBettingFlag);
    }
}

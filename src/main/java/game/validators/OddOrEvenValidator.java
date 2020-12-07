package game.validators;

import game.exceptions.NotSupportedCommandException;

import java.util.HashSet;
import java.util.Set;

public class OddOrEvenValidator {
    private static final String ODD = "1";
    private static final String EVEN = "2";

    private static final Set<String> commands = new HashSet<>();

    static {
        commands.add(ODD);
        commands.add(EVEN);
    }

    public static void validateOddOrEven(String oddOrEven) {
        if (!isAvailableCommand(oddOrEven)) {
            throw new NotSupportedCommandException();
        }
    }

    private static boolean isAvailableCommand(String oddOrEven) {
        return commands.contains(oddOrEven);
    }
}

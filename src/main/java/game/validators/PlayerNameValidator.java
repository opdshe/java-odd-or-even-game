package game.validators;

import game.domain.player.Player;
import game.exceptions.CompletelyBlankPlayerNamesException;
import game.exceptions.DuplicatedPlayerNameException;
import game.exceptions.PartiallyBlankPlayerNamesException;
import game.exceptions.TooLongPlayerNameException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerNameValidator {
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private PlayerNameValidator() {
    }

    public static void validatePlayerNames(List<String> playerNames) {
        validateCompletelyBlank(playerNames);
        validatePartiallyBlank(playerNames);
        validateNamesLength(playerNames);
        validateDuplication(playerNames);
    }

    private static void validateCompletelyBlank(List<String> playerNames) {
        if (isCompletelyBlank(playerNames)) {
            throw new CompletelyBlankPlayerNamesException();
        }
    }

    private static boolean isCompletelyBlank(List<String> playerNames) {
        return playerNames.size() == ONE && playerNames.get(ZERO).isEmpty();
    }

    private static void validatePartiallyBlank(List<String> playerNames) {
        if (isPartiallyBlank(playerNames)) {
            throw new PartiallyBlankPlayerNamesException();
        }
    }

    private static boolean isPartiallyBlank(List<String> playerNames) {
        return playerNames.stream()
                .anyMatch(String::isEmpty);
    }

    private static void validateNamesLength(List<String> playerNames) {
        if (isTooLongName(playerNames)) {
            throw new TooLongPlayerNameException();
        }
    }

    private static boolean isTooLongName(List<String> playerNames) {
        return playerNames.stream()
                .anyMatch((name) -> name.length() > Player.MAX_LENGTH_OF_PLAYER_NAME);
    }

    private static void validateDuplication(List<String> playerNames) {
        if (hasDuplicatedNames(playerNames)) {
            throw new DuplicatedPlayerNameException();
        }
    }

    private static boolean hasDuplicatedNames(List<String> playerNames) {
        Set<String> nameSet = new HashSet<>(playerNames);
        return nameSet.size() != playerNames.size();
    }
}

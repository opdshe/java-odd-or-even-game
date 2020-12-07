package game.domain;

import java.util.HashMap;
import java.util.Map;

public class SuperBettingMapper {
    private static final Map<String, Boolean> mapper = new HashMap<>();
    private static final String USE_SUPPER_BETTING = "1";
    private static final String NOT_USE_SUPPER_BETTING = "2";

    static {
        mapper.put(USE_SUPPER_BETTING, true);
        mapper.put(NOT_USE_SUPPER_BETTING, false);
    }

    public static boolean getSuperBettingFlag(String command) {
        return mapper.get(command);
    }
}

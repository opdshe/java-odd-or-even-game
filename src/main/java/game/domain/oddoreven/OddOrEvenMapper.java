package game.domain.oddoreven;

import java.util.HashMap;
import java.util.Map;

public class OddOrEvenMapper {
    private static final Map<String, OddOrEven> mapper = new HashMap<>();
    private static final String ODD = "1";
    private static final String EVEN = "2";

    static {
        mapper.put(ODD, OddOrEven.ODD);
        mapper.put(EVEN, OddOrEven.EVEN);
    }

    public static OddOrEven getOddOrEven(String oddOrEven) {
        return mapper.get(oddOrEven);
    }
}

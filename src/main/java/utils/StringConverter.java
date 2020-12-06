package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConverter {
    private static final String COMMA = ",";

    private StringConverter() {
    }

    public static List<String> toListSplitByComma(String origin) {
        return Arrays.stream(origin.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

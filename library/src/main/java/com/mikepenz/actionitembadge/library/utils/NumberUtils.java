package com.mikepenz.actionitembadge.library.utils;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by prabel on 27.07.15.
 */
public class NumberUtils {

    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();
    static {
        suffixes.put(1_000L, "k");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String formatNumber(int value) {
        if (value < 0) return "-" + formatNumber(-value);
        if (value < 1000) return Long.toString(value);

        final Map.Entry<Long, String> entry = suffixes.floorEntry((long) value);
        final Long divideBy = entry.getKey();
        final String suffix = entry.getValue();

        final long truncated = value / (divideBy / 10);
        final boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }
}

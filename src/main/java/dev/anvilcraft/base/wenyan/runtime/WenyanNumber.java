package dev.anvilcraft.base.wenyan.runtime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

public final class WenyanNumber {
    private static final Map<Character, Integer> DIGITS = Map.ofEntries(
            Map.entry('零', 0),
            Map.entry('〇', 0),
            Map.entry('一', 1),
            Map.entry('二', 2),
            Map.entry('三', 3),
            Map.entry('四', 4),
            Map.entry('五', 5),
            Map.entry('六', 6),
            Map.entry('七', 7),
            Map.entry('八', 8),
            Map.entry('九', 9)
    );

    private static final Map<Character, Integer> SMALL_UNITS = Map.of(
            '十', 10,
            '百', 100,
            '千', 1000
    );

    private static final Map<Character, Long> LARGE_UNITS = Map.of(
            '萬', 10_000L,
            '亿', 100_000_000L,
            '億', 100_000_000L,
            '兆', 1_000_000_000_000L
    );

    private WenyanNumber() {
    }

    public static BigDecimal parse(String text) {
        String s = text.trim();
        if (s.isEmpty()) {
            return BigDecimal.ZERO;
        }
        if (s.matches("-?\\d+(\\.\\d+)?")) {
            return new BigDecimal(s);
        }
        if (s.contains("又")) {
            return parseFloatLike(s);
        }
        return new BigDecimal(parseIntegerChinese(s));
    }

    private static BigDecimal parseFloatLike(String text) {
        String[] parts = text.split("又", 2);
        BigDecimal integerPart = new BigDecimal(parseIntegerChinese(parts[0]));
        String fraction = parts.length > 1 ? parts[1] : "";
        BigDecimal result = integerPart;
        result = result.add(extractFraction(fraction, "分", 10));
        result = result.add(extractFraction(fraction, "釐", 100));
        result = result.add(extractFraction(fraction, "毫", 1000));
        result = result.add(extractFraction(fraction, "絲", 10000));
        result = result.add(extractFraction(fraction, "忽", 100000));
        result = result.add(extractFraction(fraction, "微", 1000000));
        return result;
    }

    private static BigDecimal extractFraction(String source, String unit, int denominator) {
        int idx = source.indexOf(unit);
        if (idx < 0) {
            return BigDecimal.ZERO;
        }
        int start = idx - 1;
        while (start >= 0 && DIGITS.containsKey(source.charAt(start))) {
            start--;
        }
        String number = source.substring(start + 1, idx);
        if (number.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal numerator = new BigDecimal(parseIntegerChinese(number));
        return numerator.divide(BigDecimal.valueOf(denominator));
    }

    private static BigInteger parseIntegerChinese(String text) {
        BigInteger total = BigInteger.ZERO;
        BigInteger section = BigInteger.ZERO;
        int number = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (DIGITS.containsKey(ch)) {
                number = DIGITS.get(ch);
                continue;
            }
            if (SMALL_UNITS.containsKey(ch)) {
                int unit = SMALL_UNITS.get(ch);
                if (number == 0) {
                    number = 1;
                }
                section = section.add(BigInteger.valueOf((long) number * unit));
                number = 0;
                continue;
            }
            if (LARGE_UNITS.containsKey(ch)) {
                long unit = LARGE_UNITS.get(ch);
                section = section.add(BigInteger.valueOf(number));
                if (section.equals(BigInteger.ZERO)) {
                    section = BigInteger.ONE;
                }
                total = total.add(section.multiply(BigInteger.valueOf(unit)));
                section = BigInteger.ZERO;
                number = 0;
            }
        }

        section = section.add(BigInteger.valueOf(number));
        return total.add(section);
    }
}


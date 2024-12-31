package easy;

import java.util.*;

/**
 * 13. Roman to Integer
 * Easy
 * Topics
 * Companies
 * Hint
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {
    private static final String ROMAN_CHARS = "IVXLCDM";

    private static final Map<String, Integer> ROMAN_DIGITS = new HashMap<>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};

    private static final List<Integer> ROMAN_DIGITS_CAN_BE_TRIPLED = Arrays.asList(
            1,
            10,
            100,
            1000
    );

    private static final HashMap<Integer, Integer> DIGIT_WEIGHTS = new HashMap<>() {{
        put(1, 1);
        put(4, 1);
        put(5, 1);
        put(9, 1);
        put(10, 10);
        put(40, 10);
        put(50, 10);
        put(90, 10);
        put(100, 100);
        put(400, 100);
        put(500, 100);
        put(900, 100);
        put(1000, 1000);
    }};

    public static void main(String[] args) {
        String s = args[0];
        checkConstraints(s);
        System.out.println(convertRomanNumberToInteger(s));
    }

    private static void checkConstraints(String s) {
        if (s.isEmpty() || s.length() > 15) {
            throw new IllegalArgumentException("Length must be between 1 and 15");
        }

        for (int i = 0; i < s.length(); i++) {
            if (ROMAN_CHARS.indexOf(s.charAt(i)) == -1) {
                throw new IllegalArgumentException("Illegal character: " + s.charAt(i));
            }
        }
        //  It is guaranteed that s is a valid roman numeral in the range [1, 3999].
        //  The greatest valid number with IVXLCDM chars is 3999
    }

    private static int convertRomanNumberToInteger(String s) {
        List<Integer> romanNumberInDigits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && ROMAN_DIGITS.containsKey(s.substring(i, i + 2))) {
                romanNumberInDigits.add(ROMAN_DIGITS.get(s.substring(i, i + 2)));
                i++;
                continue;
            }
            if (ROMAN_DIGITS.containsKey(s.substring(i, i + 1))) {
                romanNumberInDigits.add(ROMAN_DIGITS.get(s.substring(i, i + 1)));
                continue;
            }
            throw new IllegalArgumentException("Illegal character: " + s.charAt(i));
        }

        for (int i = 0; i < romanNumberInDigits.size(); i++) {
            if (i + 1 < romanNumberInDigits.size() && romanNumberInDigits.get(i) < romanNumberInDigits.get(i + 1)) {
                throw new IllegalArgumentException("Invalid roman number!");
            }
            if (ROMAN_DIGITS_CAN_BE_TRIPLED.contains(romanNumberInDigits.get(i))) {
                if (i + 3 < romanNumberInDigits.size()
                        && Objects.equals(romanNumberInDigits.get(i), romanNumberInDigits.get(i + 1))
                        && Objects.equals(romanNumberInDigits.get(i + 1), romanNumberInDigits.get(i + 2))
                        && Objects.equals(romanNumberInDigits.get(i + 2), romanNumberInDigits.get(i + 3))
                ) {
                    throw new IllegalArgumentException("Invalid roman number!");
                }
            } else {
                if (i + 1 < romanNumberInDigits.size() && Objects.equals(
                        DIGIT_WEIGHTS.get(romanNumberInDigits.get(i)),
                        DIGIT_WEIGHTS.get(romanNumberInDigits.get(i + 1))
                )) {
                    throw new IllegalArgumentException("Invalid roman number!");
                }
            }
        }

        int decimalNumber = 0;
        for (int digit : romanNumberInDigits) {
            decimalNumber += digit;
        }

        return decimalNumber;
    }
}

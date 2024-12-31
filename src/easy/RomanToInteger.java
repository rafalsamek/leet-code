package easy;

import java.util.ArrayList;

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
    public static void main(String[] args) {
        String s = args[0];
        checkConstraints(s);
        checkIsValidRomanNumber(s);
        System.out.println(convertRomanNumberToInteger(s));
    }

    private static void checkConstraints(String s) {
        // TODO 1 <= s.length <= 15
        for (int i = 0; i < s.length(); i++) {
            if (ROMAN_CHARS.indexOf(s.charAt(i)) == -1) {
                throw new IllegalArgumentException("Illegal character: " + s.charAt(i));
            }
        }
        // TODO check that s is a valid roman numeral in the range [1, 3999]
    }

    private static void checkIsValidRomanNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (
                        (i < s.length() - 1 && s.charAt(i + 1) != 'V' && s.charAt(i + 1) != 'X' && s.charAt(i + 1) != 'I') ||
                                (i > 2 && s.charAt(i -3) == 'I' && s.charAt(i -2) == 'I' && s.charAt(i -1) == 'I') ||
                                (i > 0 && i + 1 < s.length() && s.charAt(i - 1) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
                ) {
                    throw new IllegalArgumentException("Not a valid roman number: " + s + " on position " + i);
                }
            }
            if (s.charAt(i) == 'X') {
                if (
                        (i < s.length() - 1 && s.charAt(i + 1) != 'L' && s.charAt(i + 1) != 'C' && s.charAt(i + 1) != 'X' && s.charAt(i + 1) != 'V' && s.charAt(i + 1) != 'I') ||
                                (i > 2 && s.charAt(i -3) == 'X' && s.charAt(i -2) == 'X' && s.charAt(i -1) == 'X') ||
                                (i > 0 && i + 1 < s.length() && s.charAt(i - 1) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
                ) {
                    throw new IllegalArgumentException("Not a valid roman number: " + s + " on position " + i);
                }
            }
            if (s.charAt(i) == 'C') {
                if (
                        (i < s.length() - 1 && s.charAt(i + 1) != 'D' && s.charAt(i + 1) != 'M' && s.charAt(i + 1) != 'C' && s.charAt(i + 1) != 'L' && s.charAt(i + 1) != 'X' && s.charAt(i + 1) != 'V' && s.charAt(i + 1) != 'I') ||
                                (i > 2 && s.charAt(i -3) == 'C' && s.charAt(i -2) == 'C' && s.charAt(i -1) == 'C') ||
                                (i > 0 && i + 1 < s.length() && s.charAt(i - 1) == 'C' && (s.charAt(i + 1) == 'M' || s.charAt(i + 1) == 'D'))
                ) {
                    throw new IllegalArgumentException("Not a valid roman number: " + s + " on position " + i);
                }
            }
        }
    }


    private static int convertRomanNumberToInteger(String s) {
        return 943;
    }
}

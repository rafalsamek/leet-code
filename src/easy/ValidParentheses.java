package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 20. Valid Parenthesis
 * Easy
 * Topics
 * Companies
 * Hint
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "()[]{}"
 *
 * Output: true
 *
 * Example 3:
 *
 * Input: s = "(]"
 *
 * Output: false
 *
 * Example 4:
 *
 * Input: s = "([])"
 *
 * Output: true
 *
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parenthesis only '()[]{}'.
 */
public class ValidParentheses {
    private final HashMap<Character, Parenthesis> parentheses = new HashMap<>();
    // initialize counters with 0
    private final int[] counters = new int[] {0, 0, 0};
    ValidParentheses() {
        this.parentheses.put('(', new Parenthesis(0, 1));
        this.parentheses.put(')', new Parenthesis(0, -1));
        this.parentheses.put('[', new Parenthesis(1, 1));
        this.parentheses.put(']', new Parenthesis(1, -1));
        this.parentheses.put('{', new Parenthesis(2, 1));
        this.parentheses.put('}', new Parenthesis(2, -1));
    }

    public static void main(String[] args) {
        String s = args[0];
        checkConstrants(s);
        ValidParentheses validator = new ValidParentheses();

        System.out.println(validator.validateParenthesis(s));
    }

    private static void checkConstrants(String s) {
        // 1 <= s.length <= 104
        if (s.isEmpty() || s.length() > 104) {
            throw new IllegalArgumentException("1 <= s.length <= 104");
        }

        // s consists of parenthesis only '()[]{}'.
        if (!s.matches("[()\\[\\]{}]+")) {
            throw new IllegalArgumentException("s should consist of parenthesis only '()[]{}'");
        }
    }

    private boolean validateParenthesis(String s) {
        // initialize last weight with 99
        int lastWeight = 99;
        int counterValue;
        Parenthesis singleParenthesis;
        // iterate over chars of s
        for (int i = 0; i < s.length(); i++) {
            // check if char is in parentheses if not return false
            if (!this.parentheses.containsKey(s.charAt(i))) {
                return false;
            }

            singleParenthesis = this.parentheses.get(s.charAt(i));
            // if value is 1 check if the parenthesis weight is less or equal to last weight
            if (singleParenthesis.value == 1 && singleParenthesis.weight > lastWeight) {
                return false;
            }

            // if value is -1 check if the parenthesis weight is greater or equal to last weight
            if (singleParenthesis.value == -1 && singleParenthesis.weight < lastWeight) {
                return false;
            }

            // update relevant counter
            counterValue = this.counters[singleParenthesis.weight] + singleParenthesis.value;
            this.counters[singleParenthesis.weight] = counterValue;

            // return false if the counter is less than 0
            if (counterValue < 0) {
                return false;
            }

            // set the lastWeight to singleParenthesis.weight
            lastWeight = singleParenthesis.weight;
        }

        // at the end return true if all counters are 0 false otherwise
        return Arrays.stream(this.counters).allMatch(counter -> counter == 0);
    }

    private static class Parenthesis {
        public int weight;
        public int value;

        public Parenthesis(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}

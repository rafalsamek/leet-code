package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Palindrome Number
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        checkConstraints(x);
        if(x < 0) {
            System.out.println(false);
            return;
        }
        int xReversed = reverse(x);
        System.out.println(x == xReversed);
    }

    private static int reverse(int x) {
        List<Integer> digits = new ArrayList<>();
        do {
            digits.add(x % 10);
            x /= 10;
        } while (x > 0);

        int reversed = 0;
        for(int i = 0; i < digits.size(); i++) {
            reversed += digits.get(i) * (int) Math.pow(10, digits.size() - i - 1);
        }

        return reversed;
    }

    private static void checkConstraints(int x) {
        if (x < -231 || x > 231 - 1) {
            throw new IllegalArgumentException("Number must be between -231 and 231 - 1");
        }
    }
}

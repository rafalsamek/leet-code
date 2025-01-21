package easy;

import java.util.Arrays;

/**
 * 66. Plus One
 * Easy
 * Topics
 * Companies
 * You are given a large integer represented as an integer array digits, where each digits[i]
 * is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * Example 3:
 *
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = getInput(args);
        checkConstraints(digits);
        System.out.println("Input: digits = " + Arrays.toString(digits));
        digits = plusOne(digits);
        System.out.println("Output: " + Arrays.toString(digits));
    }

    private static int[] getInput(String[] args) {
        return Arrays.stream(args).mapToInt(Integer::parseInt).toArray();
    }

    private static void checkConstraints(int[] digits) {
        if (digits.length < 1 || digits.length > 100) {
            throw new IllegalArgumentException("1 <= digits.length <= 100");
        }
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 0 || digits[i] > 9) {
                throw new IllegalArgumentException("0 <= digits[i] <= 9");
            }
            if (digits[0] ==0) {
                throw new IllegalArgumentException("digits should not contain any leading 0's");
            }
        }
    }

    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = new int[digits.length + 1];
                    newDigits[0] = 1;
                    for (int j = 1; j < newDigits.length; j++) {
                        newDigits[j] = digits[j - 1];
                    }
                    return newDigits;
                }
                continue;
            }
            return digits;
        }

        return digits;
    }
}

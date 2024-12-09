package easy;

/**
 * 1009. Complement of Base 10 Integer
 * Easy
 * Topics
 * Companies
 * Hint
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 * Example 2:
 *
 * Input: n = 7
 * Output: 0
 * Explanation: 7 is "111" in binary, with complement "000" in binary, which is 0 in base-10.
 * Example 3:
 *
 * Input: n = 10
 * Output: 5
 * Explanation: 10 is "1010" in binary, with complement "0101" in binary, which is 5 in base-10.
 *
 *
 * Constraints:
 *
 * 0 <= n < 109
 */
public class ComplementOfBase10Integer2 {
    public static void main(String[] args) {
        int decimalNumber = Integer.parseInt(args[0]);

        // check constraints
        ComplementOfBase10Integer2.checkConstraints(decimalNumber);
        System.out.println(bitwiseComplement(decimalNumber));
    }

    private static void checkConstraints(int decimalNumber) {
        // 0 <= n < 109

        if (decimalNumber < 0) {
            throw new IllegalArgumentException("provided number should be greater or equal to 0");
        }

        if (decimalNumber >= 109) {
            throw new IllegalArgumentException("provided number should be less than 109");
        }
    }

    public static int bitwiseComplement(int n) {
        if (n == 0) return 1; // Special case for 0, as its complement is 1

        // Create a mask with all bits set to 1 for the length of n's binary representation
        int mask = (Integer.highestOneBit(n) << 1) - 1;

        // XOR n with the mask to get the complement
        return n ^ mask;
    }
}

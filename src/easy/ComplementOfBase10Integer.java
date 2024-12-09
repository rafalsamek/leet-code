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

public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        int decimalNumber = Integer.parseInt(args[0]);

        // check constraints
        ComplementOfBase10Integer.checkConstraints(decimalNumber);

        System.out.println("decimal representation of the binary compement of the number: " + ComplementOfBase10Integer.complement(decimalNumber));
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

    private static int complement(int decimalNumber) {
        System.out.println("provided number: " + decimalNumber);

        int decimalComplement = 0;
        // convert to binary
        String binaryNumber = Integer.toBinaryString(decimalNumber);
        System.out.println("binary representation of the number: " + binaryNumber);

        // convert to complement
        String complementBinary = "";
        for (int i = 0; i < binaryNumber.length(); i++) {
            complementBinary += binaryNumber.charAt(i) == '0' ? '1' : '0';
        }
        System.out.println("binary complement of the number: " + complementBinary);

        // convert to decimal
        for (int i = 0; i < complementBinary.length(); i++) {
            int weight = (int) Math.pow(2, complementBinary.length() - 1 - i);
            decimalComplement += complementBinary.charAt(i) == '1' ? weight : 0;
        }

        return decimalComplement;
    }
}

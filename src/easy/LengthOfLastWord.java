package easy;

/**
 * 58. Length of Last Word
 * Easy
 * Topics
 * Companies
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 *
 * A word is a maximal
 * substring
 *  consisting of non-space characters only.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 *
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 *
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "1a";
        checkConstraints(s);
        System.out.println("Input: s = \"" + s + "\"");
        int lastWordLength = calculateLastWordLength(s);
        System.out.println("Output: " + lastWordLength);
    }

    private static void checkConstraints(String s) {
        if (s.isEmpty() || s.length() > 10000) {
            throw new IllegalArgumentException("1 <= s.length <= 10^4");
        }

        if (!s.matches("[a-zA-Z\\s]*")) {
            throw new IllegalArgumentException("s should consist of only English letters and spaces ' '");
        }

        if (!s.matches("(.*)[A-Za-z]+(.*)")) {
            throw new IllegalArgumentException("There should be at least one word in s");
        }
    }

    private static int calculateLastWordLength(String s) {
        String[] words = s.split(" ");

        return words[words.length -1].length();
    }
}

package easy;

/**
 * 14. Longest Common Prefix
 * Easy
 * Topics
 * Companies
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        StringBuilder prefix = new StringBuilder();
        boolean ShouldBreak = false;

        for (int i = 0; i < args[0].length(); i++) {
            for (int j = 1; j < args.length; j++) {
                if (args[0].charAt(i) != args[j].charAt(i)) {
                    ShouldBreak = true;
                    break;
                }
            }
            if (ShouldBreak) {
                break;
            }
            prefix.append(args[0].charAt(i));
        }

        System.out.println("\"" + prefix + "\"");
    }
}

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
//        args = new String[] {
//                "dupa",
//                "dupek",
//                "dudu",
//                "",
//        };

        StringBuilder prefix = new StringBuilder();
        checkConstraints(args);
        boolean shouldBreak = false;

        for (int i = 0; i < args[0].length(); i++) {
            for (int j = 0; j < args.length; j++) {
                if (args[j].length() < i + 1 || args[0].charAt(i) != args[j].charAt(i)) {
                    shouldBreak = true;
                    break;
                }
            }
            if (shouldBreak) {
                break;
            }
            prefix.append(args[0].charAt(i));
        }

        System.out.println("\"" + prefix + "\"");
    }

    private static void checkConstraints(String[] args) {
        if (args.length < 1 || args.length > 200) {
            throw new IllegalArgumentException("1 <= args.length <= 200");
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].length() > 200) {
                throw new IllegalArgumentException("0 <= strs[i].length <= 200");
            }

            if (!args[i].matches("[a-z]*")) {
                throw new IllegalArgumentException(
                        "strs[i] consists of only lowercase English letters if it is non-empty."
                );
            }
        }
    }
}

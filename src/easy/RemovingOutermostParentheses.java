package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1021. Remove Outermost Parentheses
 * Easy
 * Topics
 * Companies
 * Hint
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.
 *
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * A valid parentheses string s is primitive if it is nonempty, and there does not exist a way to split it into s = A + B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk, where Pi are primitive valid parentheses strings.
 *
 * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 *
 * Input: s = "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 *
 * Input: s = "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is either '(' or ')'.
 * s is a valid parentheses string.
 */

public class RemovingOutermostParentheses {
    public static void main(String[] args) {
        String parenthesis = args[0];

        // check contraints
        checkConstraints(parenthesis);

        // decomposite primitively
        List<String> primitives = decompositePrmitively(parenthesis);

        // remove outer parenthesis from each primitive
        List<String> noOuterParenthesis = removeOuterParenthesis(primitives);

        // concatenate resulted primitives
        String result = concatenate(noOuterParenthesis);

        // output
        System.out.println(result);
    }

    private static void checkConstraints(String parenthesis) {
        // 1 <= s.length <= 105
        if (parenthesis.length() < 1) {
            throw new IllegalArgumentException("s.length < 1");
        }
        if (parenthesis.length() > 105) {
            throw new IllegalArgumentException("s.length > 105");
        }
        // s[i] is either '(' or ')'.
        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) != '(' && parenthesis.charAt(i) != ')') {
                throw new IllegalArgumentException("s[i] should be either '(' or ')");
            }
        }
    }

    // (()())(())(()(()))
    private static List<String> decompositePrmitively(String parenthesis) {
        List<String> result = new ArrayList<>();
        int parenthesisCounter = 0;
        StringBuilder primitive = new StringBuilder();
        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) == '(') {
                parenthesisCounter ++;
            }
            if (parenthesis.charAt(i) == ')') {
                parenthesisCounter --;
            }
            primitive.append(parenthesis.charAt(i));

            if (parenthesisCounter == 0) {
                result.add(primitive.toString());
                primitive = new StringBuilder();
            }
        }

        return result;
    }

    private static List<String> removeOuterParenthesis(List<String> primitives) {
        List<String> result = new ArrayList<>();
        for (String primitive : primitives) {
            result.add(primitive.substring(1, primitive.length() - 1));
        }

        return result;
    }

    private static String concatenate(List<String> primitives) {
        StringBuilder result = new StringBuilder();
        for (String primitive : primitives) {
            result.append(primitive);
        }

        return result.toString();
    }
}

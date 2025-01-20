package easy;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Easy
 * Topics
 * Companies
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack and needle consist of only lowercase English characters.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = args[0];
        String needle = args[1];
        checkConstraints(haystack, needle);

        System.out.println("Input: haystack = \"" + haystack + "\", needle = \"" + needle + "\"");
        int index = findFirstIndex(haystack, needle);
        System.out.println("Output: " + index);
    }

    private static void checkConstraints(String haystack, String needle) {
        if (haystack.isEmpty() ||
                haystack.length() > Math.pow(10, 4) ||
                needle.isEmpty() ||
                needle.length() > Math.pow(10, 4)
        ) {
            throw new IllegalArgumentException("1 <= haystack.length, needle.length <= 104");
        }

        if (!haystack.matches("[a-z]+") || !needle.matches("[a-z]+")) {
            throw new IllegalArgumentException("haystack and needle consist of only lowercase English characters");
        }
    }

    private static int findFirstIndex(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

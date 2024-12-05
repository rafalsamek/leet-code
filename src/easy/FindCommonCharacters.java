package easy;

import java.util.*;

/**
 * 1002. Find Common Characters
 * Easy
 * Topics
 * Companies
 * Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 *
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
public class FindCommonCharacters {
    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        // check constraints
        FindCommonCharacters.checkConstraints(args, alphabet);

        // find common letters
        List<Character> output = FindCommonCharacters.findCommonLetters(args, alphabet);

        System.out.println(output);
    }

    private static List<Character> findCommonLetters(String[] args, String alphabet) {
        List<Character> output = new ArrayList<>();

        // iterate over lowerCaseLetters
        for (int i = 0; i < alphabet.length(); i++) {
            int countMinimum = -1;
            // than iterate over each word from args and check the minimum of occurences
            for (String word : args) {
                int count = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) == alphabet.charAt(i)) {
                        count++;
                    }
                }

                if (countMinimum == -1 || count < countMinimum) {
                    countMinimum = count;
                }
            }

            // add the letter to the output as many times as the minimum
            for (int k = 0; k < countMinimum; k++) {
                output.add(alphabet.charAt(i));
            }
        }

        return output;
    }

    private static void checkConstraints(String[] args, String alphabet) {
        // 1 <= words.length <= 100
        if (args.length < 1) {
            throw new IllegalArgumentException("Number of words is less then 1");
        }
        if (args.length > 100) {
            throw new IllegalArgumentException("Number of words is greater then 100");
        }

        // 1 <= words[i].length <= 100
        for (String word : args) {
            if (word.length() < 1) {
                throw new IllegalArgumentException("Length of words is less then 1");
            }
            if (word.length() > 100) {
                throw new IllegalArgumentException("Length of words is greater then 100");
            }
        }

        // words[i] consists of lowercase English letters.
        for (String word : args) {
            for (int i = 0; i < word.length(); i++) {
                if (alphabet.indexOf(word.charAt(i)) == -1) {
                    throw new IllegalArgumentException("Words should contain of only lower case english letters");
                }
            }
        }
    }
}

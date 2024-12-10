package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given a binary array nums (0-indexed).
 *
 * We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
 *
 * For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
 * Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,1]
 * Output: [true,false,false]
 * Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
 * Only the first number is divisible by 5, so answer[0] is true.
 * Example 2:
 *
 * Input: nums = [1,1,1]
 * Output: [false,false,false]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 */
public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        // check constraint
        String[] nums = checkConstraints(args);

        List<List<String>> subLists = createSubListsOfNums(nums);

        int [] subListsIntegers = calculateSubListsIntegers(subLists);

        System.out.println(Arrays.toString(caluclateIsDevisableBy5(subListsIntegers)));
    }

    private static String[] checkConstraints(String[] args) {
        // 1 <= nums.length <= 105
        if (args.length < 1) {
            throw new IllegalArgumentException("nums.length should be greater or equal to 1");
        }

        if (args.length > 105) {
            throw new IllegalArgumentException("nums.length should be less or equal to 105");
        }

        // nums[i] is either 0 or 1.
        for (String element : args) {
            if (!element.equals("0") && !element.equals("1")) {
                throw new IllegalArgumentException("nums[i] should be eiter 0 or 1");
            }
        }

        return args;
    }

    private static List<List<String>> createSubListsOfNums(String[] nums) {
        List<List<String>> subListsOfNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            subListsOfNums.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                subListsOfNums.get(i).add(nums[j]);
            }
        }

        return subListsOfNums;
    }

    private static int[] calculateSubListsIntegers(List<List<String>> subLists) {
        int [] subListsIntegers = new int[subLists.toArray().length];
        int i = 0;
        for (List<String> subList : subLists) {
            subListsIntegers[i] = binaryListToDecimalInteger(subList);
            i++;
        }

        return subListsIntegers;
    }

    private static int binaryListToDecimalInteger(List<String> subArray) {
        int decimalValue = 0;
        for (int i = 0; i < subArray.toArray().length; i++) {
            int weight = (int) Math.pow(2, subArray.toArray().length - 1 - i);
            decimalValue += Integer.parseInt(subArray.get(i)) * weight;
        }

        return decimalValue;
    }

    private static boolean[] caluclateIsDevisableBy5(int[] subListsIntegers) {
        boolean[] isDevisableBy5Array = new boolean[subListsIntegers.length];

        for (int i = 0; i < subListsIntegers.length; i++) {
            isDevisableBy5Array[i] = subListsIntegers[i] % 5 == 0;
        }

        return isDevisableBy5Array;
    }
}

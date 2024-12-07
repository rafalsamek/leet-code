package easy;

import java.util.Arrays;

/**
 *1005. Maximize Sum Of Array After K Negations
 * Easy
 * Topics
 * Companies
 * Given an integer array nums and an integer k, modify the array in the following way:
 *
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 *
 * Return the largest possible sum of the array after modifying it in this way.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3], k = 1
 * Output: 5
 * Explanation: Choose index 1 and nums becomes [4,-2,3].
 * Example 2:
 *
 * Input: nums = [3,-1,0,2], k = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
 * Example 3:
 *
 * Input: nums = [2,-3,-1,5,-4], k = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
public class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        // convert args to nums array and k integer
        int[] nums = new int [args.length - 1];
        int k = Integer.parseInt(args[args.length - 1]);
        for(int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(k);

        // make constraints
        MaximizeSumOfArrayAfterKNegations.checkConstraints(nums, k);

        // in a loop call negation method k times
        for (int i = 0; i < k; i++) {
            MaximizeSumOfArrayAfterKNegations.negateArray(nums);
        }

        // output sum of elements of nums array
        MaximizeSumOfArrayAfterKNegations.outputSumOfArray(nums);
    }

    private static void checkConstraints(int[] nums, int k) {
        // 1 <= nums.length <= 104
        if (nums.length < 1) {
            throw new IllegalArgumentException("nums.length < 1");
        }
        if (nums.length > 104) {
            throw new IllegalArgumentException("nums.length > 104");
        }
        // -100 <= nums[i] <= 100
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -100) {
                throw new IllegalArgumentException("nums[" + i + "] < -100");
            }
            if (nums[i] > 100) {
                throw new IllegalArgumentException("nums[" + i + "] > 100");
            }
        }
        // 1 <= k <= 104
        if (k < 1) {
            throw new IllegalArgumentException("k < 1");
        }
        if (k > 104) {
            throw new IllegalArgumentException("k > 104");
        }
    }

    private static void negateArray(int[] nums) {
        int min = nums[0];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                index = i;
            }
        }
        nums[index] = -nums[index];
    }

    private static void outputSumOfArray(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
        }

        System.out.println(sum);
    }
}

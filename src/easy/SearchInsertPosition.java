package easy;

import java.util.Arrays;
import java.util.logging.SocketHandler;

/**
 * 35. Search Insert Position
 * Easy
 * Topics
 * Companies
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be if it were inserted
 * in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = convertArgsToIntArray(args);
        int target = convertArgsToIntTarget(args);
        checkConstraints(nums, target); 
        int index = findIndex(nums, target);


        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output: " + index);
    }

    private static int findIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevent potential overflow
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left; // The position where the target would be inserted
    }

    private static void checkConstraints(int[] nums, int target) {
        if (nums.length < 1 || nums.length > Math.pow(10, 4)) {
            throw new IllegalArgumentException("1 <= nums.length <= 10^4");
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -10000 || nums[i] > 10000) {
                throw new IllegalArgumentException("-10^4 <= nums[i] <= 10^4");
            }
            if ( i > 0 && nums[i] < nums[i -1]) {
                throw new IllegalArgumentException("nums contains distinct values sorted in ascending order");
            }
        }
        if (target < -10000 || target > 10000) {
            throw new IllegalArgumentException("-10^4 <= target <= 10^4");
        }
    }

    private static int[] convertArgsToIntArray(String[] args) {
        int[] array = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            array[i] = Integer.parseInt(args[i]);
        }
        return array;
    }

    private static int convertArgsToIntTarget(String[] args) {
        return(Integer.parseInt(args[args.length - 1]));
    }
}

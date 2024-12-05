package easy;

/**
 * 1013. Partition Array Into Three Parts With Equal Sum
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * Example 2:
 *
 * Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 * Example 3:
 *
 * Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 5 * 104
 * -104 <= arr[i] <= 104
 */
public class ArrayWith3EqualSums {
    public static void main(String[] args) throws IllegalArgumentException {
        // convert String[] to int[]
        int[] array = ArrayWith3EqualSums.convertArrayToIntArray(args);

        // check constraints
        ArrayWith3EqualSums.checkContraints(array);

        // calculate sum of elements of array
        int sumOfArrayElements = ArrayWith3EqualSums.calculateSumOfArrayElements(array);

        // check if sum of elements is dividable by 3
        if (!ArrayWith3EqualSums.isDividableByThree(sumOfArrayElements)) {
            System.out.println("false");
            return;
        }

        // calculate part sum
        int partSum = ArrayWith3EqualSums.calculatePartSum(sumOfArrayElements);

        // check if first partition possible if not output false and return
        if (ArrayWith3EqualSums.isPartitionPossible(array, partSum)) {
            System.out.println("first partition: false");
            return;
        }

        // check if second partition possible if not output false and return
        if (ArrayWith3EqualSums.isPartitionPossible(array, 2 * partSum)) {
            System.out.println("second partition: false");
            return;
        }

        // output true
        System.out.println("true");
    }

    private static void checkContraints(int[] array) throws IllegalArgumentException {
        if (array.length < 3) {
            throw new IllegalArgumentException("array.length < 3");
        }

        if (array.length > 5 * 104) {
            throw new IllegalArgumentException("array.length > 5 * 104");
        }

        for (int j : array) {
            if (j < -104) {
                throw new IllegalArgumentException("array[i] < -104");
            }

            if (j > 104) {
                throw new IllegalArgumentException("array[i] > 104");
            }
        }
    }

    private static boolean isPartitionPossible(int[] array, int partSum) {
        int sum = 0;
        for (int j : array) {
            sum += j;
            if (sum == partSum) {
                return false;
            }

            if (sum > partSum) {
                return true;
            }
        }

        return true;
    }

    private static int calculatePartSum(int sumOfArrayElements) {
        return sumOfArrayElements / 3;
    }

    private static boolean isDividableByThree(int sumOfArrayElements) {
        return sumOfArrayElements % 3 == 0;
    }

    private static int calculateSumOfArrayElements(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }

        return sum;
    }

    private static int[] convertArrayToIntArray(String[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }

        return intArray;
    }
}

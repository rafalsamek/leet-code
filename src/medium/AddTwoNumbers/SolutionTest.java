package medium.AddTwoNumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("testAddTwoNumbersProvider")
    void testAddTwoNumbers(int[] input1, int[] input2, int[] expected) {
        // Build linked lists from the input arrays
        ListNode l1 = buildList(input1);
        ListNode l2 = buildList(input2);

        // Call the (unimplemented) solution
        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Convert the result linked list to an int array
        int[] actual = listToArray(result);

        // Compare actual with expected
        assertArrayEquals(expected, actual,
                "The linked list sum does not match the expected output.");
    }

    /**
     * Provides test data for the parameterized test.
     * Each Object[] has three arrays:
     *   - First array: digits of the first number in reverse order
     *   - Second array: digits of the second number in reverse order
     *   - Third array: expected result in reverse order
     */
    static List<Object[]> testAddTwoNumbersProvider() {
        return Arrays.asList(
                // Example 1: l1 = [2,4,3], l2 = [5,6,4] => output = [7,0,8]
                new Object[]{ new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8} },

                // Example 2: l1 = [0], l2 = [0] => output = [0]
                new Object[]{ new int[]{0},      new int[]{0},      new int[]{0} }
        );
    }

    // --------------------------------------------------------------
    // Helper methods to build and read ListNode-based linked lists
    // --------------------------------------------------------------

    /**
     * Builds a singly-linked list from an int array, where each element
     * corresponds to a node's value (in given order).
     */
    private ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Converts a linked list to an int array by traversing each node.
     */
    private int[] listToArray(ListNode head) {
        // We'll collect values in a dynamic structure then convert to int[]
        java.util.ArrayList<Integer> values = new java.util.ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }
}

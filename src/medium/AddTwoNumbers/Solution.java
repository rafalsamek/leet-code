package medium.AddTwoNumbers;

/**
 * 2. Add Two Numbers
 * Medium
 * Topics
 * Companies
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        checkConstraints(l1, l2);
        int i1 = convertListNodeToInt(l1);
        int i2 = convertListNodeToInt(l2);

        return convertIntToListNode(i1 + i2);
    }

    private void checkConstraints(ListNode l1, ListNode l2) {
        int l1NumberOfNodes = numberOfNodes(l1);
        int l2NumberOfNodes = numberOfNodes(l2);
        if (l1NumberOfNodes < 1 || l1NumberOfNodes > 100 || l2NumberOfNodes < 1 || l2NumberOfNodes > 100) {
            throw new IllegalArgumentException(
                    "The number of nodes in each linked list should be in the range [1, 100]."
            );
        }

        checkNodeVals(l1);
        checkNodeVals(l2);

        checkLeadingZeros(l1);
        checkLeadingZeros(l2);
    }

    private void checkLeadingZeros(ListNode listNode) {
        StringBuilder intNumber = new StringBuilder();
        while (listNode != null) {
            intNumber.append(listNode.val);
            listNode = listNode.next;
        }

        String intNumberString1 = intNumber.reverse().toString();
        String intNumberString2 = String.valueOf(Integer.parseInt(intNumberString1));

        if (intNumberString1.length() != intNumberString2.length()) {
            throw new IllegalArgumentException(
                    "It should be guaranteed that the list represents a number that does not have leading zeros."
            );
        }
    }

    private void checkNodeVals(ListNode listNode) {
        while (listNode != null) {
            if (listNode.val < 0 || listNode.val > 9) {
                throw new IllegalArgumentException(
                        "should be: 0 <= Node.val <= 9"
                );
            }
            listNode = listNode.next;
        }
    }

    private int numberOfNodes(ListNode listNode) {
        int numberOfNodes = 0;
        while (listNode != null) {
            numberOfNodes++;
            listNode = listNode.next;
        }

        return numberOfNodes;
    }

    private int convertListNodeToInt(ListNode listNode) {
        StringBuilder intNumber = new StringBuilder();
        while (listNode != null) {
            intNumber.append(listNode.val);
            listNode = listNode.next;
        }

        return Integer.parseInt(intNumber.reverse().toString());
    }

    private ListNode convertIntToListNode(int intNumber) {
        String intNumberString = new StringBuilder(String.valueOf(intNumber)).reverse().toString();
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        for (int i = 0; i < intNumberString.length(); i++) {
            listNode.val = Integer.parseInt(String.valueOf(intNumberString.charAt(i)));
            if (i < intNumberString.length() - 1) {
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }

        return head;
    }
}

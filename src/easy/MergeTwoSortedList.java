package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 21. Merge Two Sorted Lists
 * Easy
 * Topics
 * Companies
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = getList(args[0]);
        ListNode list2 = getList(args[1]);
        checkConstraints(list1, list2);
        System.out.println("Input: list1 = " + list1 + ", list2 = " + list2);

        System.out.println("Output: " + mergeTwoSortedLinkedLists(list1, list2));
    }

    private static void checkConstraints(ListNode list1, ListNode list2) {
        checkList(list1);
        checkList(list2);
    }

    private static void checkList(ListNode list) {
        int numberOfNodes = 0;
        ListNode previousNode = null;
        while (list != null) {
            numberOfNodes++;
            if (list.val < -100 || list.val > 100) {
                throw new IllegalArgumentException("-100 <= Node.val <= 100");
            }
            if (previousNode != null) {
                if (list.val < previousNode.val) {
                    throw new IllegalArgumentException("Both list1 and list2 are sorted in non-decreasing order.");
                }
            }
            previousNode = list;
            list = list.next;
        }
        if (numberOfNodes > 50) {
            throw new IllegalArgumentException("The number of nodes in both lists should be in the range [0, 50].");
        }
    }

    private static ListNode getList(String listString) {
        List<Integer> integerList = new ArrayList<>(
                Arrays.stream(listString.split("\\|"))
                        .map(Integer::parseInt).toList()
        );
        ListNode head = new ListNode(
                getFirstElementFromIntegerList(integerList),
                null,
                true
        );
        addElementToLinkedList(head, integerList);

        return head;
    }

    private static void addElementToLinkedList(ListNode list, List<Integer> integerList) {
        if (!integerList.isEmpty()) {
            list.next = new ListNode(
                    getFirstElementFromIntegerList(integerList)
            );
            addElementToLinkedList(list.next, integerList);
        }
    }

    private static int getFirstElementFromIntegerList(List<Integer> integerList) {
        int val = integerList.get(0);
        integerList.remove(0);

        return val;
    }

    private static ListNode mergeTwoSortedLinkedLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }

        if (list2 == null && list1 != null) {
            return list1;
        }

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list2.val < list1.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        ListNode mergedLists = list1;

        list2.isHead = false;

        while (list2 != null) {
            if (list1.next == null || list2.val <= list1.next.val) {
                ListNode tmp1 = list1.next;
                ListNode tmp2 = list2.next;
                list1.next = list2;
                list2.next = tmp1;
                list2 = tmp2;
            } else {
                list1 = list1.next;
            }
        }

        return mergedLists;
    }

    public static class ListNode {
        int val;
        ListNode next;
        boolean isHead = false;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int val, ListNode next, boolean isHead) {
            this.val = val;
            this.next = next;
            this.isHead = isHead;
        }

        @Override
        public String toString() {
            return (this.isHead ? "[" : "") + this.val + (this.next != null ? "," + this.next : "") + (this.isHead ? "]" : "");
        }
    }
}

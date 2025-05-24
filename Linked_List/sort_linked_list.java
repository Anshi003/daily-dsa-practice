/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
     * Sorts the linked list using bottom-up merge sort.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Get length of the list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Dummy node initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 3: Bottom-up merge sort
        for (int size = 1; size < length; size *= 2) {
            ListNode prev = dummy;
            current = dummy.next;

            while (current != null) {
                // Step 3.1: Split the list into two parts
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);

                // Step 3.2: Merge two sorted sublists
                prev.next = merge(left, right);

                // Step 3.3: Move prev to the tail of the merged list
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    // Helper method to split the list and return the second part
    private ListNode split(ListNode head, int n) {
        if (head == null) return null;
        for (int i = 1; i < n && head.next != null; i++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    // Helper method to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}

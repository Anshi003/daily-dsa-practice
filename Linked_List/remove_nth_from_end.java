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
     * Removes the n-th node from the end of the linked list and returns the head.
     *
     * First computes the size of the list, then removes the (size - n)th node from the front.
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        // Step 1: Count total number of nodes
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Step 2: Find the node just before the one to be removed
        int indexToRemove = size - n;

        // Special case: removing the head
        if (indexToRemove == 0) {
            return head.next;
        }

        temp = head;
        for (int i = 1; i < indexToRemove; i++) {
            temp = temp.next;
        }

        // Step 3: Remove the nth node from end
        temp.next = temp.next.next;

        return head;
    }
}

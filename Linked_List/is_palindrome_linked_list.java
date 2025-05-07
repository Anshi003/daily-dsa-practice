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
     * Determines whether a singly-linked list is a palindrome.
     * 
     * Approach:
     * - Use the fast and slow pointer technique to find the middle of the list.
     * - Reverse the second half of the list.
     * - Compare both halves.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find middle using slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half of the list
        ListNode secondHalf = reverseList(slow.next);

        // Compare both halves
        ListNode firstHalf = head;
        ListNode current = secondHalf;
        while (current != null) {
            if (firstHalf.val != current.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            current = current.next;
        }

        return true;
    }

    /**
     * Reverses a singly-linked list.
     */
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}

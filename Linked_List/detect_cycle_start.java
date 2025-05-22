/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    /**
     * Detects the start of the cycle in a linked list using Floyd's Tortoise and Hare algorithm.
     * If no cycle exists, returns null.
     *
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle possible
        }

        ListNode slow = head;
        ListNode fast = head;

        // Detect cycle using two-pointer approach
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move slow to head, and advance both pointers at the same pace
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Node where cycle begins
        return slow;
    }
}

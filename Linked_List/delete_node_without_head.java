// Definition for singly-linked list.
// public class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int x) { val = x; }
// }

class Solution {
    /**
     * Deletes a given node from a singly linked list without access to the head.
     * This is done by copying the value from the next node into the current node,
     * and then bypassing the next node.
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    /**
     * Returns an array of the maximum values in each sliding window of size k.
     *
     * Approach:
     * - Use a deque to store indices of useful elements in the current window.
     * - Remove elements outside the window or smaller than the current number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        int index = 0;

        for (int j = 0; j < n; j++) {
            if (!dq.isEmpty() && dq.peek() < j - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }

            dq.offer(j);
            if (j >= k - 1) {
                result[index++] = nums[dq.peek()];
            }
        }

        return result;
    }
}

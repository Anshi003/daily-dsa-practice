class Solution {

    /**
     * Finds the maximum number of consecutive 1's in a binary array
     * if at most k 0's can be flipped.
     *
     * Sliding Window Approach:
     * - Expand the window with pointer j.
     * - Count zeros in the window.
     * - If zeros exceed k, shrink the window from the left (pointer i).
     * - Track the max window size that satisfies the constraint.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int zeros = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            if (nums[j] == 0) {
                zeros++;
            }

            // Shrink window from the left if zero count exceeds k
            while (zeros > k) {
                if (nums[i] == 0) {
                    zeros--;
                }
                i++;
            }

            // Update max length of valid window
            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}

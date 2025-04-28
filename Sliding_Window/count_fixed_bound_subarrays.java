class Solution {
    /**
     * Counts the number of fixed-bound subarrays where the minimum and maximum values
     * match minK and maxK respectively.
     *
     * Approach:
     * - Track last seen positions of minK and maxK.
     * - Track the last invalid position (where nums[i] is out of bounds).
     * - For each index, the number of valid subarrays ending at i is (min(minKPosition, maxKPosition) - culpritIdx).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                culpritIdx = i;
            }
            if (nums[i] == maxK) {
                maxKPosition = i;
            }
            if (nums[i] == minK) {
                minKPosition = i;
            }
            long smaller = Math.min(minKPosition, maxKPosition);
            long temp = smaller - culpritIdx;
            ans += (temp <= 0) ? 0 : temp;
        }
        return ans;
    }
}

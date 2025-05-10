class Solution {

    /**
     * Rearranges numbers into the lexicographically next greater permutation.
     * If no such permutation exists (array is in descending order), rearranges
     * to the lowest possible order (ascending).
     *
     * Steps:
     * 1. Traverse from end and find the first index `i` where nums[i] < nums[i+1].
     * 2. Then find the smallest number greater than nums[i] from the end and swap.
     * 3. Finally, reverse the suffix starting at i+1.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // Step 1: Find the first decreasing element from the right
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: If found, find the next bigger element and swap
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse the suffix
        reverse(nums, i + 1, n - 1);
    }

    // Helper method to swap two elements
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a subarray
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}

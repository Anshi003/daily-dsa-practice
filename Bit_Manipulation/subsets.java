class Solution {
    /**
     * Returns all possible subsets (the power set) of a given array.
     *
     * Approach:
     * - Use bit masking: Each integer from 0 to 2^n - 1 represents a subset.
     * - The i-th bit of the integer determines if nums[i] is included.
     *
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(2^n * n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n;
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}

class Solution {
    /**
     * Computes the sum of even numbers in the array after each query.
     * Each query updates nums[index] += val.
     *
     * @param nums    The initial integer array.
     * @param queries The list of queries [val, index].
     * @return Array of sums of even numbers after each query.
     */
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int sumEven = 0;

        // Initial sum of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                sumEven += num;
            }
        }

        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            // If current value is even, subtract it before update
            if (nums[idx] % 2 == 0) {
                sumEven -= nums[idx];
            }

            // Update the value at index
            nums[idx] += val;

            // If updated value is even, add it back
            if (nums[idx] % 2 == 0) {
                sumEven += nums[idx];
            }

            result[i] = sumEven;
        }

        return result;
    }
}

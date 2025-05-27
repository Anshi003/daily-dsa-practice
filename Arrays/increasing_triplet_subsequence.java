class Solution {
    /**
     * Returns true if there exists a triplet (i < j < k) such that
     * nums[i] < nums[j] < nums[k].
     *
     * Uses O(n) time and O(1) space.
     *
     * @param nums The input array of integers.
     * @return true if such a triplet exists, false otherwise.
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        // Initialize the first and second numbers in the triplet to max value
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num3 = nums[i];

            if (num3 <= num1) {
                // num3 becomes the new smallest value
                num1 = num3;
            } else if (num3 <= num2) {
                // num3 is larger than num1 but smaller than num2
                num2 = num3;
            } else {
                // num3 is greater than both num1 and num2
                return true;
            }
        }

        // No such triplet found
        return false;
    }
}

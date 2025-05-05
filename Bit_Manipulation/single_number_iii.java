class Solution {
    /**
     * Finds the two elements that appear only once in the array
     * where all other elements appear exactly twice.
     *
     * Approach:
     * - XOR all elements to get xor = x ^ y (x and y are unique numbers).
     * - Find a set bit (mask) in xor to separate x and y.
     * - XOR again based on the mask to recover x and y individually.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & -xor;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}

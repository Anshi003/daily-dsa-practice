class Solution {
    /**
     * Returns the sum of two integers without using '+' or '-' operators.
     *
     * Approach:
     * - Use bitwise XOR to get the sum without carry.
     * - Use bitwise AND and left shift to compute the carry.
     * - Repeat until carry is 0.
     *
     * Time Complexity: O(1) (constant time for 32-bit integers)
     * Space Complexity: O(1)
     */
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = a & b;
        while (carry != 0) {
            a = sum;
            b = carry << 1;
            sum = a ^ b;
            carry = a & b;
        }
        return sum;
    }
}

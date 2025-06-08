import java.util.Stack;

public class Solution {

    /**
     * Checks whether a given array contains a 132 pattern:
     * A subsequence of three integers nums[i], nums[j], and nums[k]
     * such that i < j < k and nums[i] < nums[k] < nums[j].
     *
     * Approach:
     * Traverse the array from right to left using a stack to track potential nums[j] values,
     * and keep updating the nums[k] candidate (called num3 here).
     *
     * If a current number is less than the candidate for nums[k],
     * it means we have found nums[i] < nums[k] < nums[j] — the 132 pattern.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums The input integer array
     * @return true if a 132 pattern exists, false otherwise
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num3 = Integer.MIN_VALUE; // This is the candidate for nums[k]
        Stack<Integer> stack = new Stack<>(); // This helps track possible nums[j]

        for (int i = n - 1; i >= 0; i--) {
            // If we find nums[i] < num3, the 132 pattern exists
            if (nums[i] < num3) {
                return true;
            }

            // While nums[i] > stack.peek(), pop from stack and update num3
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num3 = stack.pop(); // num3 stores the max value less than nums[i]
            }

            stack.push(nums[i]); // nums[i] may be a future nums[j]
        }

        return false; // No 132 pattern found
    }
}

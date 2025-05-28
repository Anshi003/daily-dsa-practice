import java.util.*;

class Solution {
    /**
     * Given a circular array, returns the next greater number for each element.
     * If no such greater number exists, return -1 for that element.
     *
     * @param nums The circular array of integers.
     * @return An array containing the next greater element for each position.
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Default to -1 if no greater element is found
        Stack<Integer> stack = new Stack<>();

        // Loop through the array twice to simulate circular traversal
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            // Pop indices from stack where current num is the next greater
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }

            // Only push index from first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}

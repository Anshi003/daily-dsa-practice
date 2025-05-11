import java.util.*;

class Solution {

    /**
     * Finds all unique triplets in the array which gives the sum of zero.
     * 
     * Approach:
     * 1. Sort the array to use the two-pointer technique efficiently.
     * 2. Iterate through the array fixing one number and using two pointers to find the other two.
     * 3. Skip duplicates to avoid repeated triplets.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (ignoring the output list)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Step 1: Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // Step 2: Use two-pointer to find the remaining two numbers
            twoSum(nums, i + 1, result, -nums[i]);
        }

        return result;
    }

    // Helper method to find two numbers which sum to the target
    private void twoSum(int[] nums, int start, List<List<Integer>> result, int target) {
        int i = start, j = nums.length - 1;

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                // Add the triplet
                result.add(Arrays.asList(-target, nums[i], nums[j]));

                // Skip duplicates for the second and third numbers
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }

                i++;
                j--;
            }
        }
    }
}

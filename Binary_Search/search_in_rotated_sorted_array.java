class Solution {

    /**
     * Searches for a target value in a possibly rotated sorted array.
     * 
     * The algorithm performs a modified binary search in O(log n) time.
     * It works by identifying which half of the array is sorted at each step
     * and then narrowing the search space accordingly.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums The rotated sorted array with distinct integers.
     * @param target The target value to search for.
     * @return True if target is found, otherwise false.
     */
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return true;

            // Handle duplicates (if allowed), skip them
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}

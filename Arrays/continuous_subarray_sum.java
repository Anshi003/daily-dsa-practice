import java.util.*;

class Solution {
    /**
     * Checks if there exists a continuous subarray of at least two elements
     * whose sum is a multiple of k.
     *
     * @param nums The input array.
     * @param k The target integer to check multiples of.
     * @return True if such a subarray exists, otherwise false.
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1); // For subarrays starting from index 0

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (mp.containsKey(remainder)) {
                if (i - mp.get(remainder) >= 2) {
                    return true;
                }
            } else {
                mp.put(remainder, i);
            }
        }

        return false;
    }
}

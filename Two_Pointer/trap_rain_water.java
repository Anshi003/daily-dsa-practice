class Solution {

    /**
     * Finds the index of the maximum element between indices i and j (inclusive).
     */
    public int max(int[] arr, int i, int j) {
        int m = Integer.MIN_VALUE;
        int mx = i;
        for (int p = i; p <= j; p++) {
            if (arr[p] > m) {
                m = arr[p];
                mx = p;
            }
        }
        return mx;
    }

    /**
     * Calculates the total amount of trapped rain water using the two-pointer approach.
     *
     * Approach:
     * - First, find the index of the highest bar (global maximum).
     * - Traverse from the left to this maximum, accumulating trapped water.
     * - Then traverse from the right to the maximum, similarly.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int trap(int[] height) {
        int n = height.length;
        int L = 0;
        int R = n - 1;
        int water = 0;

        int maxIdx = max(height, 0, n - 1);

        // Traverse from left to global max
        for (int i = 1; i < maxIdx; i++) {
            if (height[L] > height[i]) {
                water += height[L] - height[i];
            } else {
                L = i;
            }
        }

        // Traverse from right to global max
        for (int j = n - 2; j > maxIdx; j--) {
            if (height[R] > height[j]) {
                water += height[R] - height[j];
            } else {
                R = j;
            }
        }

        return water;
    }
}

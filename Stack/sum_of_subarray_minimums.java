import java.util.*;

public class Solution {
    
    /**
     * Helper method to find Nearest Smaller to Left (NSL) for each element.
     * Returns an array where result[i] is the index of the previous smaller element.
     */
    public int[] getNSL(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    /**
     * Helper method to find Nearest Smaller to Right (NSR) for each element.
     * Returns an array where result[i] is the index of the next smaller element.
     */
    public int[] getNSR(int[] arr, int n) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    /**
     * Main method to compute the sum of minimums of all subarrays.
     * Uses the concepts of NSL and NSR to count the contribution of each element.
     * Time Complexity: O(n)
     *
     * @param arr input array
     * @return sum of all subarray minimums modulo 10^9 + 7
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] NSL = getNSL(arr, n);
        int[] NSR = getNSR(arr, n);

        long sum = 0;
        int M = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long left = i - NSL[i];     // number of elements to the left (including current)
            long right = NSR[i] - i;    // number of elements to the right (including current)

            long count = left * right;              // total subarrays where arr[i] is minimum
            long contribution = arr[i] * count;     // contribution of arr[i] to the final sum

            sum = (sum + contribution) % M;
        }

        return (int) sum;
    }
}

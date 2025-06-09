import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Builds a list of "Push" and "Pop" operations to simulate filling a stack
     * such that the final stack matches the target array.
     *
     * The stream of integers ranges from 1 to n, and at each step:
     * - If the stream number is needed in the target, we just "Push".
     * - If not, we "Push" and immediately "Pop" to skip it.
     *
     * We stop once we've constructed the complete target sequence.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param target The target array to match using stack operations.
     * @param n The upper limit of the stream of integers [1...n].
     * @return A list of operations ("Push"/"Pop") to form the target.
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int stream = 1; // Pointer to the current number in the input stream
        int i = 0;      // Pointer to the target array

        // Loop until we process all elements in target
        while (i < target.length && stream <= n) {
            result.add("Push");

            if (stream == target[i]) {
                i++; // Keep the pushed element
            } else {
                result.add("Pop"); // Discard it
            }

            stream++;
        }

        return result;
    }
}

import java.util.*;

class Solution {
    /**
     * Reconstructs the original array from the given "doubled" array.
     *
     * @param changed the doubled array
     * @return the original array if valid, otherwise an empty array
     */
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // If length is odd, it can't be a doubled array
        if (n % 2 != 0) {
            return new int[]{};
        }

        Arrays.sort(changed); // Sort to handle smaller numbers first

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : changed) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int num : changed) {
            if (freq.getOrDefault(num, 0) == 0) continue;

            int twice = 2 * num;

            if (freq.getOrDefault(twice, 0) == 0) {
                return new int[]{};
            }

            result.add(num);
            freq.put(num, freq.get(num) - 1);
            freq.put(twice, freq.get(twice) - 1);
        }

        // Convert List to array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

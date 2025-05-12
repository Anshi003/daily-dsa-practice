import java.util.*;

class Solution {

    /**
     * Sorts characters in the string in decreasing order of frequency.
     *
     * Approach:
     * 1. Count frequency of each character using a HashMap.
     * 2. Sort the characters based on their frequency using a custom comparator.
     * 3. Build the resulting string by repeating characters according to their frequency.
     *
     * Time Complexity: O(n log n), where n is the length of the string (due to sorting).
     * Space Complexity: O(n), for frequency map and result string.
     */
    public String frequencySort(String s) {
        // Step 1: Count frequencies
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort characters by frequency
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a)); // Descending order

        // Step 3: Build result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int freq = freqMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}

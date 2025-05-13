class Solution {

    /**
     * Calculates the total beauty of all substrings of the given string.
     *
     * The beauty of a substring is defined as the difference between the highest 
     * and lowest frequency of any character in that substring (excluding characters
     * that don’t appear).
     *
     * Approach:
     * - Iterate through all substrings.
     * - Maintain a frequency count of characters for each substring.
     * - At each step, find the max and min frequencies and compute beauty.
     *
     * Time Complexity: O(n^2 * 26) ≈ O(n^2) since 26 is constant
     * Space Complexity: O(26) = O(1) for frequency array
     */
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                freq[c - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                int beauty = maxFreq - minFreq;
                totalBeauty += beauty;
            }
        }

        return totalBeauty;
    }
}

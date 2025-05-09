class Solution {

    /**
     * Finds the length of the longest substring with the same letter 
     * after at most k replacements.
     *
     * Sliding Window Approach:
     * - Expand window with pointer j and keep count of characters.
     * - Track the most frequent character in the window (maxCount).
     * - If current window size - maxCount > k, shrink window from left (i).
     * - The condition ensures we never exceed k allowed replacements.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) - constant space for character count array
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int maxLength = 0;
        int maxCount = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            count[s.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(j) - 'A']);

            // If more than k characters need to be replaced, shrink window
            if ((j - i + 1) - maxCount > k) {
                count[s.charAt(i) - 'A']--;
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
        }

        return maxLength;
    }
}

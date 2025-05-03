import java.util.HashMap;

class Solution {
    /**
     * Returns the length of the longest substring without repeating characters.
     *
     * Approach:
     * - Use a sliding window with two pointers.
     * - Use a HashMap to store the last seen index of characters.
     * - Move the start of the window (i) when a duplicate character is found.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(k), where k is the character set size (typically 128 or 256)
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int len = 0;
        int n = s.length();

        while (j < n) {
            if (mp.containsKey(s.charAt(j))) {
                i = Math.max(mp.get(s.charAt(j)) + 1, i);
            }
            mp.put(s.charAt(j), j);
            len = Math.max(len, j - i + 1);
            j++;
        }

        return len;
    }
}

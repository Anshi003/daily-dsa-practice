import java.util.HashMap;

class Solution {
    /**
     * Finds the minimum window in string s which contains all characters of string t.
     *
     * Approach:
     * - Count frequency of characters in t.
     * - Expand the window by moving `j` until all required characters are covered.
     * - Then, try to shrink the window from `i` while still meeting the requirement.
     * - Keep track of the minimum window seen.
     *
     * Time Complexity: O(m + n), where m = s.length() and n = t.length()
     * Space Complexity: O(1), since character map size is bounded by alphabet (52 at most)
     */
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) {
            return "";
        }

        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = t.length();
        int i = 0, j = 0;
        int minWindowSize = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char ch = s.charAt(j);
            if (mp.containsKey(ch) && mp.get(ch) > 0) {
                requiredCount--;
            }
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);

            while (requiredCount == 0) {
                int currentWinSize = j - i + 1;
                if (minWindowSize > currentWinSize) {
                    minWindowSize = currentWinSize;
                    start_i = i;
                }

                char startChar = s.charAt(i);
                mp.put(startChar, mp.getOrDefault(startChar, 0) + 1);
                if (mp.containsKey(startChar) && mp.get(startChar) > 0) {
                    requiredCount++;
                }
                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}

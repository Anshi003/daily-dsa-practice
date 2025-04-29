import java.util.*;

class Solution {
    /**
     * Finds all start indices of p's anagrams in s using a sliding window.
     *
     * Approach:
     * - Count character frequencies of p.
     * - Slide a window of size p.length() across s, updating frequency counts.
     * - At each step, check if the current window is an anagram by verifying all counts are zero.
     *
     * Time Complexity: O(n * 26) ~ O(n), since the alphabet size is constant.
     * Space Complexity: O(1), using fixed-size arrays for frequency counts.
     */
    private boolean allZero(int[] count) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] count = new int[26];

        for (char ch : p.toCharArray()) {
            count[ch - 'a']++;
        }

        int i = 0, j = 0;
        int n = s.length();
        ArrayList<Integer> result = new ArrayList<>();

        while (j < n) {
            count[s.charAt(j) - 'a']--;

            if ((j - i + 1) == k) {
                if (allZero(count)) {
                    result.add(i);
                }
                count[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return result;
    }
}

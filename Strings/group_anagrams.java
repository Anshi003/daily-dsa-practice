import java.util.*;

/**
 * Groups anagrams from the given array of strings.
 * 
 * Time Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
 * Space Complexity: O(N * K)
 */
class Solution {

    /**
     * Generates a normalized version of the string by counting characters
     * and reconstructing a sorted-like string using character frequencies.
     * For example, "eat" and "tea" both become "aet".
     */
    private String generate(String s) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder newS = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                newS.append(String.valueOf((char) (i + 'a')).repeat(count[i]));
            }
        }

        return newS.toString();
    }

    /**
     * Groups strings from the input array that are anagrams of each other.
     * 
     * @param strs The array of strings.
     * @return A list of lists of grouped anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String newS = generate(s);
            map.computeIfAbsent(newS, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

public class Solution {
    
    /**
     * Removes stars and their corresponding closest non-star characters to the left.
     * 
     * Uses a StringBuilder as a stack-like structure to efficiently append or remove characters.
     * 
     * Time Complexity: O(n), where n is the length of the string.
     * Space Complexity: O(n), for the result builder.
     * 
     * @param s Input string containing lowercase letters and '*' characters.
     * @return Final string after all star operations.
     */
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                result.deleteCharAt(result.length() - 1); // Remove the last character before '*'
            } else {
                result.append(ch); // Append character to result
            }
        }
        
        return result.toString();
    }
}

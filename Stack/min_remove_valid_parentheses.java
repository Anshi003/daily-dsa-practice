import java.util.HashSet;
import java.util.Stack;

public class Solution {

    /**
     * Removes the minimum number of parentheses to make the given string valid.
     *
     * A string is valid if:
     * - It contains only lowercase letters.
     * - Or it is a concatenation of valid strings.
     * - Or it is enclosed in matching parentheses with valid content.
     *
     * The algorithm uses a stack to track unmatched '(' and a set to record indices to remove.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param s The input string possibly containing invalid parentheses.
     * @return A valid parentheses string after minimum removals.
     */
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        HashSet<Integer> toRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        // First pass: track unmatched ')' and positions of unmatched '('
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    toRemove.add(i); // unmatched ')'
                } else {
                    st.pop(); // valid pair
                }
            }
        }

        // Add remaining unmatched '(' positions to removal set
        while (!st.isEmpty()) {
            toRemove.add(st.pop());
        }

        // Second pass: build the result excluding indices marked for removal
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}

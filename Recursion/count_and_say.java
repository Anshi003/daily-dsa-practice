class Solution {
    /**
     * Generates the nth term in the Count and Say sequence using recursion.
     * Each term is constructed by applying run-length encoding (RLE)
     * to the previous term.
     *
     * Base Case:
     *   countAndSay(1) = "1"
     *
     * Example:
     *   countAndSay(4) = "1211" because:
     *     countAndSay(1) = "1"
     *     countAndSay(2) = "11" (one 1)
     *     countAndSay(3) = "21" (two 1s)
     *     countAndSay(4) = "1211" (one 2, one 1)
     *
     * @param n the index of the term in the Count and Say sequence
     * @return the nth term as a String
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);  // Recursively get the previous term
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }

        // Append the final group
        result.append(count).append(prev.charAt(prev.length() - 1));

        return result.toString();
    }
}

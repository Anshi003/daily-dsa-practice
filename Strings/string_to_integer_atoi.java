class Solution {
    /**
     * Converts a string to a 32-bit signed integer similar to C/C++'s atoi function.
     *
     * Steps:
     * - Trim leading whitespaces
     * - Handle optional '+' or '-' sign
     * - Convert digits until non-digit character or end of string
     * - Clamp result within Integer.MIN_VALUE and Integer.MAX_VALUE
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int i = 0;
        long result = 0;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        result = result * sign;
        return (int) result;
    }
}

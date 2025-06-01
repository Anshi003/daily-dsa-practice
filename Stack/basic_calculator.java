import java.util.Stack;

class Solution {
    /**
     * Evaluates a valid mathematical expression string containing:
     * digits, '+', '-', '(', ')', and whitespaces.
     *
     * Rules:
     * - '+' is only binary
     * - '-' can be unary or binary
     * - Nested parentheses are allowed
     *
     * @param s The input string representing the expression
     * @return The evaluated result as an integer
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();  // multiply with previous sign
                result += stack.pop();  // add previous result
            }
        }

        result += sign * number;
        return result;
    }
}

import java.util.Stack;

public class Solution {
    
    /**
     * Validates whether a given popped sequence can result from 
     * a stack that is pushed using the pushed sequence.
     *
     * We simulate the pushing and popping process:
     * - Push elements from pushed[] one by one.
     * - After each push, pop elements from the stack if they match popped[].
     * 
     * Time Complexity: O(n), where n is the length of the input arrays
     * Space Complexity: O(n), for the auxiliary stack
     *
     * @param pushed The order in which elements are pushed onto the stack
     * @param popped The order in which elements must be popped from the stack
     * @return true if the sequence is valid, false otherwise
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        int n = pushed.length;
        
        while (i < n && j < n) {
            stack.push(pushed[i]);
            
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            i++;
        }
        
        return stack.isEmpty(); // if all elements were matched and popped
    }
}

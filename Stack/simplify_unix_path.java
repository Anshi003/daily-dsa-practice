public class Solution {
    
    /**
     * Simplifies a given Unix-style absolute path into its canonical form.
     *
     * Rules:
     * - '.' means current directory (ignored)
     * - '..' means go up one directory (pop from stack)
     * - '//' treated as a single '/'
     * - Any other string is treated as a valid directory name
     *
     * Time Complexity: O(n), where n is the length of the path string
     * Space Complexity: O(n), for storing directory names in a stack
     *
     * @param path Input absolute Unix path
     * @return Simplified canonical path
     */
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue; // Skip empty or current directory
            }
            
            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // Move up to parent directory
                }
            } else {
                stack.push(token); // Add valid directory name
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() == 0 ? "/" : result.toString();
    }
}

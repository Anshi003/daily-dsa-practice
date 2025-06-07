import java.util.Stack;

public class Solution {

    /**
     * Simulates collisions between asteroids based on their direction and size.
     * Positive values move right, negative values move left.
     *
     * Collisions occur when a right-moving asteroid meets a left-moving asteroid.
     * - The smaller asteroid explodes.
     * - If both are equal in size, both explode.
     * - Asteroids moving in the same direction never collide.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param asteroids Array representing asteroid directions and sizes
     * @return Array representing the state of asteroids after all collisions
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int sum = a + stack.peek();
                if (sum < 0) {
                    stack.pop(); // a is larger, keep checking
                } else if (sum > 0) {
                    a = 0; // a is destroyed
                    break;
                } else {
                    stack.pop(); // both explode
                    a = 0;
                }
            }

            if (a != 0) {
                stack.push(a); // a survives
            }
        }

        // Convert stack to array
        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

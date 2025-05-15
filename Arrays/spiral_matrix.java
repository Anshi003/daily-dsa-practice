class Solution {

    /**
     * Returns all elements of the matrix in spiral order.
     *
     * The traversal follows this pattern:
     * → → →      (left to right)
     * ↓         (top to bottom)
     * ← ← ←     (right to left)
     * ↑         (bottom to top)
     * ... until all elements are covered
     *
     * Time Complexity: O(m * n) — where m = number of rows, n = number of columns
     * Space Complexity: O(1) — excluding the result list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int direction = 0; // 0:→, 1:↓, 2:←, 3:↑

        while (top <= bottom && left <= right) {
            if (direction == 0) { // Left to Right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
            } else if (direction == 1) { // Top to Bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            } else

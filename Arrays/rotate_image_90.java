class Solution {

    /**
     * Rotates the given n x n 2D matrix by 90 degrees clockwise in-place.
     *
     * Approach:
     * 1. Transpose the matrix: convert rows to columns.
     * 2. Reverse each row.
     *
     * Example:
     * Input: [[1,2,3],
     *         [4,5,6],
     *         [7,8,9]]
     * Step 1 (Transpose): [[1,4,7],
     *                      [2,5,8],
     *                      [3,6,9]]
     * Step 2 (Reverse rows): [[7,4,1],
     *                         [8,5,2],
     *                         [9,6,3]]
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (in-place)
     */
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
        }
    }
}

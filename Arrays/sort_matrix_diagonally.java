class Solution {

    /**
     * Sorts each diagonal of the matrix in ascending order.
     *
     * A diagonal is identified by its key: (row - column). All elements with the same key
     * belong to the same diagonal.
     *
     * Time Complexity: O(m * n * log(min(m, n)))
     *   - For each diagonal: collect, sort, and place back.
     * Space Complexity: O(m * n)
     */
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Map to store each diagonal using key = row - col
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Group elements by diagonals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        // Step 2: Sort each diagonal list
        for (List<Integer> diagonal : map.values()) {
            Collections.sort(diagonal);
        }

        // Step 3: Fill back sorted values from bottom-right to preserve order
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int key = i - j;
                List<Integer> diagonal = map.get(key);
                mat[i][j] = diagonal.remove(diagonal.size() - 1); // pop from end for efficiency
            }
        }

        return mat;
    }
}

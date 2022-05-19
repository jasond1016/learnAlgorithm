package leetcode.p0329_longest_increasing_path_in_a_matrix;

public class Solution {
    int[][] directions = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(solution.longestIncreasingPath(matrix));
        System.out.println("-------------------");
        matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        System.out.println(solution.longestIncreasingPath(matrix));
        System.out.println("-------------------");
        matrix = new int[][]{{1}};
        System.out.println(solution.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currRes = dfs(matrix, i, j, memo);
//                System.out.println("matrix[" + i + "][" + j + "]: " + matrix[i][j] + ", " + currRes);
                res = Math.max(res, currRes);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int maxLength = 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            maxLength = Math.max(maxLength, dfs(matrix, x, y, memo) + 1);
        }
        memo[i][j] = maxLength;
        return maxLength;
    }
}

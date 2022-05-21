package leetcode.p0064_minimum_path_sum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        memo[0][0] = grid[0][0];
        return dp(grid, m - 1, n - 1, memo);
    }

    private int dp(int[][] grid, int i, int j, int[][] memo) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int left = dp(grid, i, j - 1, memo);
        int top = dp(grid, i - 1, j, memo);
        memo[i][j] = grid[i][j] + Math.min(left, top);
        return memo[i][j];
    }
}

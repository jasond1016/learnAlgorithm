package leetcode.p0063_unique_paths_2;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = new int[][]
                {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }

        return dp(obstacleGrid, m - 1, n - 1, memo);
    }

    private int dp(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if (i < 0 || j < 0 || obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        if (i == 0 && j == 0) {
            return 1;
        }

        memo[i][j] = dp(obstacleGrid, i - 1, j, memo) + dp(obstacleGrid, i, j - 1, memo);
        return memo[i][j];
    }
    
}

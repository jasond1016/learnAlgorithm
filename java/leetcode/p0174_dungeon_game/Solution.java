package leetcode.p0174_dungeon_game;

import java.util.Arrays;

/**
 * @author Wang Botai
 * @date 2022/08/17 18:25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dungeon = new int[][]{
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };
        System.out.println(solution.calculateMinimumHP(dungeon)); // 7

        dungeon = new int[][]{
                {0}
        };
        System.out.println(solution.calculateMinimumHP(dungeon)); // 1
    }

    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(dungeon, 0, 0);
    }

    /**
     * 从[i, j]到终点（右下角）所需最少生命值为dp[grid, i, j]
     */
    private int dp(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] >= 0 ? 1 : -grid[i][j] + 1;
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int res = Math.min(dp(grid, i + 1, j), dp(grid, i, j + 1)) - grid[i][j];
        memo[i][j] = (res <= 0 ? 1 : res);
        return memo[i][j];
    }
}

package leetcode.p1020_number_of_enclaves;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(solution.numEnclaves(grid));
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // sink top left bottom right edge lands
        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        // sink
        grid[i][j] = 0;

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

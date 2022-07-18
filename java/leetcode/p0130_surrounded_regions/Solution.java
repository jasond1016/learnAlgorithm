package leetcode.p0130_surrounded_regions;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}
        };
        solution.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
    
    private class UF {
        int[] parents;
        int count;

        public UF(int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            if (rootOfP == rootOfQ) {
                return;
            }

            parents[rootOfP] = rootOfQ;
            count--;
        }

        public boolean connected(int p, int q) {
            int rootOfP = find(p);
            int rootOfQ = find(q);
            return rootOfP == rootOfQ;
        }

        public int count() {
            return count;
        }

        private int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        int dummy = m * n;
        UF uf = new UF(m * n + 1);

        // 将首列和尾列的'O'和dummy相连
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(dummy, i * n);
            }

            if (board[i][n - 1] == 'O') {
                uf.union(dummy, i * n + n - 1);
            }
        }

        // 将首行和尾行的'O'和dummy相连
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(dummy, i);
            }

            if (board[m - 1][i] == 'O') {
                uf.union(dummy, (m - 1) * n + i);
            }
        }

        // 上下左右遍历
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    // 将这个'O'与上下左右连通的'O'连通
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (board[x][y] == 'O') {
                            uf.union(i * n + j, x * n + y);
                        }
                    }
                }
            }
        }
        
        // 所有不和 dummy 连通的'O'都要替换成'X'
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

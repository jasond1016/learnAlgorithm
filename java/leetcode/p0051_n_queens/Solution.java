package leetcode.p0051_n_queens;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
        System.out.println(solution.solveNQueens(1));
    }

    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return res;
    }

    // 在 row 行放置皇后
    private void backtrack(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            res.add(convert(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!isValid(board, row, j)) {
                continue;
            }
            // 做选择
            board[row][j] = 'Q';
            backtrack(board, row + 1);
            // 撤销选择
            board[row][j] = '.';
        }

    }

    // 是否可以在 [i, j] 出放置皇后
    // 因为是按从左到右，从上到下顺序放置皇后，
    // 所以只需要验证所在列、左上、右上是否有皇后即可
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查所在列是否有皇后
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上是否有皇后
        int i = row - 1;
        int j = col - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上是否有皇后
        i = row - 1;
        j = col + 1;
        for (; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> convert(char[][] board) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}

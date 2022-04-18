package leetcode.p0037_sudoku_solver;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
    }
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int row, int column) {
        if (row == 8 && column == 9) {
            return true;
        }

        if (column == 9) {
            column = 0;
            row++;
        }

        char c = board[row][column];
        if (c == '.') {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, row, column, i)) {
                    board[row][column] = (char)('0' + i);
                    if (solve(board, row, column + 1)) {
                        return true;
                    }
                    board[row][column] = '.';
                }
            }
            return false;
        } else {
            return solve(board, row, column + 1);
        }
    }

    private boolean isValid(char[][] board, int row, int column, int value) {
        for (int k = 0; k < 9; k++) {
            if (board[k][column] == (char)('0' + value)) {
                return false;
            }
            if (board[row][k] == (char)('0' + value)) {
                return false;
            }
        }
        int rowStart = row / 3 * 3;
        int columnStart = column / 3 * 3;
        for (int k = rowStart; k < rowStart + 3; k++) {
            for (int l = columnStart; l < columnStart + 3; l++) {
                if (board[k][l] == (char)('0' + value)) {
                    return false;
                }
            }
        }
        return true;
    }
}

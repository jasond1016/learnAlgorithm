package leetcode.p0036_valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && board[i][j] == board[k][j]) {
                            return false;
                        }
                        if (k != j && board[i][j] == board[i][k]) {
                            return false;
                        }
                    }
                    int rowStart = i / 3 * 3;
                    int columnStart = j / 3 * 3;
                    for (int k = rowStart; k < rowStart + 3; k++) {
                        for (int l = columnStart; l < columnStart + 3; l++) {
                            if (k != i && l != j && board[i][j] == board[k][l]) {
                                return false;
                            }
                        }
                    }
                    
                }
            }
        }
        return true;
    }
}
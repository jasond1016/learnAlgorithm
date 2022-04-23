package chapter39_back_tracking;

public class Sudoku {

    private int[][] sodokuProblem;

    public Sudoku(int[][] sodokuProblem) {
        this.sodokuProblem = sodokuProblem;
    }

    public static void main(String[] args) {
        int[][] sodokuProblem = new int[][]{
            {2, 0, 4, 0, 6, 5, 3, 1, 7},
            {5, 0, 1, 3, 4, 9, 0, 6, 8},
            {8, 0, 3, 0, 0, 0, 9, 0, 0},
            {0, 3, 0, 0, 0, 2, 0, 0, 0},
            {0, 0, 5, 0, 0, 0, 0, 2, 6},
            {0, 0, 0, 6, 9, 0, 5, 7, 0},
            {0, 1, 9, 0, 8, 6, 0, 0, 0},
            {0, 0, 6, 0, 0, 0, 7, 0, 0},
            {0, 5, 0, 2, 3, 0, 0, 0, 1}
    };
//        int[][] sodokuProblem = new int[][]{
//                {0, 1, 0, 7, 0, 0, 0, 0, 0},
//                {0, 0, 0, 9, 0, 0, 0, 6, 0},
//                {2, 0, 0, 0, 1, 6, 0, 0, 4},
//                {0, 0, 0, 0, 7, 0, 0, 0, 0},
//                {9, 0, 0, 0, 0, 0, 5, 0, 0},
//                {0, 5, 0, 0, 4, 1, 0, 8, 0},
//                {0, 0, 3, 0, 0, 0, 0, 0, 2},
//                {0, 0, 0, 6, 0, 0, 0, 0, 0},
//                {0, 9, 0, 0, 5, 8, 0, 4, 0}
//        };

        Sudoku sudoku = new Sudoku(sodokuProblem);
        sudoku.solve(0, 0);
    }

    public void solve(int i, int j) {
        if (i == 8 && j == 9) {
            printSodoku();
            return;
        }

        if (j >= 9) {
            i++;
            j = 0;
        }

        if (sodokuProblem[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (isOk(k, i, j)) {
                    sodokuProblem[i][j] = k;
                    solve(i, j + 1);
                    sodokuProblem[i][j] = 0;
                }
            }
        } else {
            solve(i, j + 1);
        }
    }

    private boolean isOk(int option, int row, int column) {
        for (int i = 0; i < 9; i++) {
            if (sodokuProblem[row][i] == option || sodokuProblem[i][column] == option) {
                return false;
            }
        }

        int squareStart = row / 3 * 3;
        int squareEnd = column / 3 * 3;
        for (int i = squareStart; i < squareStart + 3; i++) {
            for (int j = squareEnd; j < squareEnd + 3; j++) {
                if (i != row && j != column && sodokuProblem[i][j] == option) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printSodoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sodokuProblem[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

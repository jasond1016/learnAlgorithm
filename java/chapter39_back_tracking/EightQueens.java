package chapter39_back_tracking;

public class EightQueens {
    static int[] result = new int[8];

    public static void main(String[] args) {
        cal8Queens(0);
    }

    public static void cal8Queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }

        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8Queens(row + 1);
            }
        }
    }

    public static boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;

        for(int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }

            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }

            if (rightUp <= 7 && result[i] == rightUp) {
                return false;
            }

            leftUp--;
            rightUp++;
        }
        return true;
    }

    public static void printQueens(int[] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

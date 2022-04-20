package chapter41_dynamic_programming;

public class Dp2 {
    private final static int[][] matrix = {
            {1, 3, 5, 9},
            {2, 1, 3, 4},
            {5, 2, 6, 7},
            {6, 8, 4, 3},

    };

    private final static int n = matrix.length;
    private static int[][] memo = new int[n][n];

    public static void main(String[] args) {
        Dp2 dp = new Dp2();
        System.out.println(dp.minDist(n - 1, n - 1));
    }

    public int minDist(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        int minLeft = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }


        int minUp = Integer.MAX_VALUE;
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }

        int currentMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        memo[i][j] = currentMinDist;
        return currentMinDist;
    }
}

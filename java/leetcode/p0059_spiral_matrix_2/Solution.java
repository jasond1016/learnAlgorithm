package leetcode.p0059_spiral_matrix_2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upperBound = 0;
        int lowerBound = n - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        int num = 1;
        while (num <= n * n) {
            // 从左到右遍历
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    matrix[upperBound][i] = num++;
                }
                upperBound++;
            }
            // 从上到下遍历
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    matrix[i][rightBound] = num++;
                }
                rightBound--;
            }
            // 从右到左遍历
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    matrix[lowerBound][i] = num++;
                }
                lowerBound--;
            }
            // 从下到上遍历
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    matrix[i][leftBound] = num++;
                }
                leftBound++;
            }
        }
        return matrix;
    }
}

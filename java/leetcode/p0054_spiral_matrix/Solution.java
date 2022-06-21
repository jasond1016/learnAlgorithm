package leetcode.p0054_spiral_matrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        System.out.println(solution.spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int upperBound = 0;
        int lowerBound = m - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        while (res.size() < m * n) {
            // 从左到右遍历
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }
                upperBound++;
            }
            // 从上到下遍历
            if (leftBound <= rightBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }
            // 从右到左遍历
            if (upperBound <= lowerBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowerBound][i]);
                }
                lowerBound--;
            }
            // 从下到上遍历
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }
}

package leetcode.p0048_rotate_image;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线进行镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再对每行反转，即可得到矩阵顺时针旋转90度
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    private void reverse(int[] row) {
        int i = 0;
        int j = row.length - 1;
        while (j > i) {
            int temp = row[j];
            row[j] = row[i];
            row[i] = temp;
            j--;
            i++;
        }
    }
}

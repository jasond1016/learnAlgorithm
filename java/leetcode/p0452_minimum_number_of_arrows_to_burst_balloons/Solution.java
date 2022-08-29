package leetcode.p0452_minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12},
        };
        System.out.println(solution.findMinArrowShots(points)); // 2

        points = new int[][]{
                {1,2},
                {3,4},
                {5,6},
                {7,8},
        };
        System.out.println(solution.findMinArrowShots(points)); // 4

        points = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {4,5},
        };
        System.out.println(solution.findMinArrowShots(points)); // 2
    }
    public int findMinArrowShots(int[][] points) {
        return helper(points);
    }

    private int helper(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int count = 1;
        int x = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] cur = points[i];
            // 和 435 题有一点不同: start == x 时也算重叠
            if (cur[0] > x) {
                count++;
                x = cur[1];
            }
        }
        return count;
    }
}

package leetcode.p1288_remove_covered_intervals;

import java.util.Arrays;

/**
 * Solution
 *
 * @author Jason
 * @date 2022/09/19 18:00
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{
                {1,4},
                {3,6},
                {2,8},
        };
        System.out.println(solution.removeCoveredIntervals(intervals)); // 2

        intervals = new int[][]{
                {1,4},
                {2,3},
        };
        System.out.println(solution.removeCoveredIntervals(intervals)); // 1
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int res = intervals.length;
        int right = 0;

        for (int[] interval : intervals) {
            if (interval[1] <= right) {
                res--;
            } else {
                right = interval[1];
            }
        }

        return res;
    }
}


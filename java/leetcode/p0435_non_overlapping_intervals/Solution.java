package leetcode.p0435_non_overlapping_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{
                {1,2},
                {2,3},
                {3,4},
                {1,3},
        };
        System.out.println(solution.eraseOverlapIntervals(intervals)); // 1

        intervals = new int[][]{
                {1,2},
                {1,2},
                {1,2},
        };
        System.out.println(solution.eraseOverlapIntervals(intervals)); // 2

        intervals = new int[][]{
                {1,2},
                {2,3},
        };
        System.out.println(solution.eraseOverlapIntervals(intervals)); // 0
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - intervalSchedule(intervals);
    }

    /**
     * 解法分几步：
     * 1. 时间区间按 end 升序排列
     * 2. 首先选取 end 最小的（结束最早的）
     * 3. 找出下一个不重叠区间（start >= end），更新 end和计数，循环2
     * @param intervals 一组时间区间 [start_i, end_i]
     * @return 最大不重叠区间数
     */
    private int intervalSchedule(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // 1. 时间区间按 end 升序排列
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int count = 1;
        // 2. 首先选取 end 最小的（结束最早的）
        int x = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] >= x) {
                // 3. 找出下一个不重叠区间（start >= end），更新 end和计数，循环2
                count++;
                x = cur[1];
            }
        }
        return count;
    }
}

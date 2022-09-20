package leetcode.p0056_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jason
 * @date 2022/09/20 18:23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        };
        System.out.println(Arrays.deepToString(solution.merge(intervals))); // [[1,6],[8,10],[15,18]]

        intervals = new int[][]{
                {1, 4},
                {4, 5},
        };
        System.out.println(Arrays.deepToString(solution.merge(intervals))); // [[1,5]]

        intervals = new int[][]{
                {1, 4},
                {0, 4},
        };
        System.out.println(Arrays.deepToString(solution.merge(intervals))); // [0, 4]
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int left = -1;
        int right = -1;
        for (int[] interval : intervals) {
            if (interval[1] < right) {
                // 完全包含在前一个 interval 中
                continue;
            } else if (interval[0] <= right) {
                // 当前 interval 和 前一个 interval 合并
                res.remove(res.size() - 1);
                res.add(new int[]{left, interval[1]});
                right = interval[1];
            } else {
                // 不合并
                res.add(interval);
                left = interval[0];
                right = interval[1];
            }
        }

        return res.toArray(new int[0][0]);
    }
}

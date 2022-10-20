package leetcode.p0986_interval_list_intersections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wang Botai
 * @date 2022/10/20 18:19
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] firstList = new int[][]{
                {0, 2},
                {5, 10},
                {13, 23},
                {24, 25},
        };
        int[][] secondList = new int[][]{
                {1, 5},
                {8, 12},
                {15, 24},
                {25, 26},
        };
        System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList, secondList))); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

        firstList = new int[][]{
                {1, 3},
                {5, 9},
        };
        secondList = new int[][]{
        };
        System.out.println(Arrays.deepToString(solution.intervalIntersection(firstList, secondList))); // []
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (firstList[i][1] < secondList[j][0] || secondList[j][1] < firstList[i][0]) {
                // 没有交集
            } else {
                // 取交集
                int left = Math.max(firstList[i][0], secondList[j][0]);
                int right = Math.min(firstList[i][1], secondList[j][1]);
                list.add(new int[]{left, right});
            }

            // 决定哪个数组索引需要前进一步
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return list.toArray(new int[0][0]);
    }
}

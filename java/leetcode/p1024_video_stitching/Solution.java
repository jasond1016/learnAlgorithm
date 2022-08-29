package leetcode.p1024_video_stitching;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] clips = new int[][]{
                {0, 2},
                {4, 6},
                {8, 10},
                {1, 9},
                {1, 5},
                {5, 9},
        };
        int time = 10;
        System.out.println(solution.videoStitching(clips, time)); // 3

        clips = new int[][]{
                {0, 1},
                {1, 2},
        };
        time = 5;
        System.out.println(solution.videoStitching(clips, time)); // -1

        clips = new int[][]{
                {0, 1}, {6, 8}, {0, 2}, {5, 6}, {0, 4}, {0, 3}, {6, 7}, {1, 3}, {4, 7}, {1, 4}, {2, 5}, {2, 6}, {3, 4}, {4, 5}, {5, 7}, {6, 9}
        };
        time = 9;
        System.out.println(solution.videoStitching(clips, time)); // 3
    }

    public int videoStitching(int[][] clips, int time) {
        if (time == 0) {
            return 0;
        }

        // 按起点升序>终点降序排序
        Arrays.sort(clips, (c1, c2) -> {
            if (c1[0] == c2[0]) {
                return c2[1] - c1[1];
            }
            return c1[0] - c2[0];
        });

        // 选取片段数
        int count = 0;
        int curEnd = 0;
        int nextEnd = 0;
        int i = 0;
        int n = clips.length;
        //
        while (i < n && clips[i][0] <= curEnd) {
            // 在起点小于当前重点中选取终点最大的
            while (i < n && clips[i][0] <= curEnd) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }
            // 找到下一个片段，更新 curEnd
            count++;
            curEnd = nextEnd;
            if (nextEnd >= time) {
                // 可以还原出所有视频
                return count;
            }
        }
        return -1;
    }
}

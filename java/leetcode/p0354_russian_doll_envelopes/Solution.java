package leetcode.p0354_russian_doll_envelopes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] envelopse = new int[][]{
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        System.out.println(solution.maxEnvelopes(envelopse)); // 3
    }

    /**
     * int[i] = [width, height]
     * 先按宽升序排列，宽相同时按高降序排列
     * 拿到高度数组后，求最长递增子序列就为套娃层数
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int n = envelopes.length;
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }

    private int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] top = new int[n];
        int piles = 0;
        for (int i = 0; i < n; i++) {
            int poker = nums[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                } else {
                    right = mid;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}

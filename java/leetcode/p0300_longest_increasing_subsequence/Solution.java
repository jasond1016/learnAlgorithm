package leetcode.p0300_longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1,9,2,4,7,6,5,101,18};
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        int[] nums = new int[]{0,1,0,3,2,3};
        int[] nums = new int[]{4,10,4,3,8,9};
        System.out.println(solution.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int longest = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int j : dp) {
            if (j > longest) {
                longest = j;
            }
        }
        return longest;
    }
}

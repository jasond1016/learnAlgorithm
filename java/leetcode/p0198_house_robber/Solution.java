package leetcode.p0198_house_robber;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums));

        nums = new int[]{2,7,9,3,1};
        System.out.println(solution.rob(nums));
    }

    // 备忘录
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        if (memo[start] != -1) {
            return memo[start];
        }

        int res = Math.max(
                // 不抢这家
                dp(nums, start + 1),
                // 抢这家
                nums[start] + dp(nums, start + 2));
        memo[start] = res;
        return res;
    }
}

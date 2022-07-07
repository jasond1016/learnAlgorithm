package leetcode.p0198_house_robber;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(solution.rob3(nums));

        nums = new int[]{2,7,9,3,1};
        System.out.println(solution.rob3(nums));
    }

    // 备忘录
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    // 自顶向下
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

    // 自底向上
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >=0 ; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    // 空间复杂度优化
    public int rob3(int[] nums) {
        int n = nums.length;
        int dpi = 0;
        int dp1 = 0;
        int dp2 = 0;
        
        for (int i = n - 1; i >=0 ; i--) {
            dpi = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dpi;
        }
        return dpi;
    }
}

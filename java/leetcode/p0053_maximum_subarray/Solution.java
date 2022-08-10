package leetcode.p0053_maximum_subarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums)); // 6

        nums = new int[]{1};
        System.out.println(solution.maxSubArray(nums)); // 1

        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(solution.maxSubArray(nums)); // 23
    }

    int[] dp;

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp(nums, i);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private int dp(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        }
        return Math.max(nums[i] + dp(nums, i - 1), nums[i]);
    }
}

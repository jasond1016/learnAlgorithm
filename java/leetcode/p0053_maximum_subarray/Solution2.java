package leetcode.p0053_maximum_subarray;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

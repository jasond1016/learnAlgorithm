package leetcode.p0416_partition_equal_subset_sum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(nums)); // true

        nums = new int[]{1, 2, 3, 5};
        System.out.println(solution.canPartition(nums)); // false

        nums = new int[]{1, 5, 10, 6};
        System.out.println(solution.canPartition(nums)); // true
    }

    /**
     * 转换成背包问题
     * 设 nums[]合计为 sum，给定背包容纳重量为 sum / 2，和 N 个物品，
     * 每个物品重量为 nums[i]，是否存在一种装法能恰好将背包装满？
     **/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            // 奇数不可平分
            return false;
        }

        sum = sum / 2;
        // dp[i][j] = x 表示，对于前 i 个物品（i 从 1 开始计数），当前背包剩余容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] > j) {
                    // 背包容量不足
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 第i个数放进背包 || 不放进背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}

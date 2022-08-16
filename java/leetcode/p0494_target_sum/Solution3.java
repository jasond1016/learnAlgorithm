package leetcode.p0494_target_sum;

/**
 * @author Wang Botai
 * @date 2022/08/16 18:59
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target)); // 5

        nums = new int[]{1};
        target = 1;
        System.out.println(solution.findTargetSumWays(nums, target)); // 1
    }


    /**
     * 可以做转换为背包问题：
     * 可以把 nums 分为两组，一组取正值，一组取负值，则有：
     * sum(A) - sum(B) = target
     * sum(A) = target + sum(B)
     * 2 * sum(A) = target + sum(A) + sum(B)
     * 2 * sum(A) = target + sum(nums)
     * sum(A) = (target + sum(nums)) / 2
     * 即求存在多少子集A可以满足上述公式
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum + target) % 2 == 1 || sum < Math.abs(target)) {
            return 0;
        }

        return subsets(nums, (target + sum) / 2);
    }

    private int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}

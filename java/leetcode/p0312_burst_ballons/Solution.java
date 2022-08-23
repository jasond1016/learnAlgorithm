package leetcode.p0312_burst_ballons;

/**
 * @author Wang Botai
 * @date 2022/08/23 19:10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 1, 5, 8};
        System.out.println(solution.maxCoins(nums)); // 167

        nums = new int[]{1, 5};
        System.out.println(solution.maxCoins(nums)); // 10
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 为两边添加虚拟气球，分值为1
        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);

        // 定义 dp[i][j] 为 戳破 i ~ j 之间的气球所能获得的最大分值
        // base case： 对所有 i > j dp[i][j] = 0  
        int[][] dp = new int[n + 2][n + 2];
        // i 从下往上
        for (int i = n; i >= 0; i--) {
            // j 从左到右
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]);
                }
            }
        }

        return dp[0][n + 1];
    }

}

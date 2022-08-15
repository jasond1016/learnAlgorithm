package leetcode.p0518_coin_change_2;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(solution.change(amount, coins)); // 4

        amount = 3;
        coins = new int[]{2};
        System.out.println(solution.change(amount, coins)); // 0

        amount = 10;
        coins = new int[]{10};
        System.out.println(solution.change(amount, coins)); // 1
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 若只使用 coins 中的前 i 个（i 从 1 开始计数）硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法。
        int[][] dp = new int[n + 1][amount + 1];
        // base case 为 dp[0][..] = 0, dp[..][0] = 1。
        // i = 0 代表不使用任何硬币面值，这种情况下显然无法凑出任何金额；
        // j = 0 代表需要凑出的目标金额为 0，那么什么都不做就是唯一的一种凑法。
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    // 不使用i这枚硬币 + 使用i这枚硬币
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}

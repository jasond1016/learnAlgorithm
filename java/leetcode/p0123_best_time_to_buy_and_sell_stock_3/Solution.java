package leetcode.p0123_best_time_to_buy_and_sell_stock_3;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(prices));

        prices = new int[]{1,2,3,4,5};
        System.out.println(solution.maxProfit(prices));

        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxK = 2;
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = maxK; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][maxK][0];
    }
}

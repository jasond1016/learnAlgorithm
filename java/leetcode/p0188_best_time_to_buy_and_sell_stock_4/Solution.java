package leetcode.p0188_best_time_to_buy_and_sell_stock_4;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 2;
        int[] prices = new int[]{2,4,1};
        System.out.println(solution.maxProfit(k, prices));

        k = 2;
        prices = new int[]{3,2,6,5,0,3};
        System.out.println(solution.maxProfit(k, prices));

        k = 2;
        prices = new int[]{};
        System.out.println(solution.maxProfit(k, prices));
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }

                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}

package leetcode.p0714_best_time_to_buy_and_sell_stock_with_transaction_fee;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{1,3,2,8,4,9};
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));

        prices = new int[]{1,3,7,5,10,3};
        fee = 3;
        System.out.println(solution.maxProfit(prices, fee));
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}

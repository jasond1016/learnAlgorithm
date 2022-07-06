package leetcode.p0122_best_time_to_buy_and_sell_stock_2;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));

        prices = new int[]{1,2,3,4,5};
        System.out.println(solution.maxProfit(prices));

        prices = new int[]{7,6,4,3,1};
        System.out.println(solution.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }
}

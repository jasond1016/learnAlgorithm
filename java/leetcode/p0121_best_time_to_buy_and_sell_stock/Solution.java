package leetcode.p0121_best_time_to_buy_and_sell_stock;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(solution.maxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices));
        prices = new int[]{1, 2};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minValue = prices[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            res = Math.max(res, prices[i] - minValue);
        }
        return res;
    }

    public int maxProfitSlow(int[] prices) {
        int n = prices.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }
}

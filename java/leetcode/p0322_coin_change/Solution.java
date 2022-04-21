package leetcode.p0322_coin_change;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{186,419,83,408};
        int amount = 6249;
        System.out.println(solution.coinChange2(coins, amount));
    }
    
    // back tracking plus memo
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChangeRecur(memo, coins, amount);
    }

    private int coinChangeRecur(int[] memo, int[] coins, int amount) {
        if (memo[amount] != 0) {
            return memo[amount];
        }
        
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            if (amount == coins[i]) {
                return 1;
            }
        }

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                continue;
            }
            int val = coinChangeRecur(memo, coins, amount - coins[i]);
            if (val == -1) {
                continue;
            }
            int value = 1 + val;
            if (value < minValue) {
                minValue = value;
            }
        }

        if (minValue == Integer.MAX_VALUE) {
            memo[amount] = -1;
            return -1;
        } else {
            memo[amount] = minValue;
            return minValue;
        }
    }

    // dp
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] result = new int[amount + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                
                if (coin > i) {
                    continue;
                }

                if (coin == i) {
                    result[i] = 1;
                    break;
                }

                if (result[i - coin] > 0) {
                    result[i] = Math.min(result[i - coin] + 1, result[i]);
                }
            }
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        return result[amount];
    }
}

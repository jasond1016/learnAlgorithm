package leetcode.p0877_stone_game;

/**
 * @author Wang Botai
 * @date 2022/08/25 19:13
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = new int[]{5, 3, 4, 5};
        System.out.println(solution.stoneGame(piles)); // true

        piles = new int[]{3, 7, 2, 3};
        System.out.println(solution.stoneGame(piles)); // true
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][i] = new Pair(piles[i], 0);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;

                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }

        Pair pair = dp[0][n - 1];
        return pair.fir > pair.sec;
    }

    private static class Pair {
        int fir;
        int sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}

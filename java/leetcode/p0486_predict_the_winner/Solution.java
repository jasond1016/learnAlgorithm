package leetcode.p0486_predict_the_winner;

/**
 * @author Wang Botai
 * @date 2022/08/24 18:21
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 2};
        System.out.println(solution.PredictTheWinner(nums)); // false

        nums = new int[]{1, 5, 233, 7};
        System.out.println(solution.PredictTheWinner(nums)); // true
    }

    public boolean PredictTheWinner(int[] nums) {
        return stoneGame(nums) >= 0;
    }

    private int stoneGame(int[] nums) {
        int n = nums.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        /**
         * base case
         * i == j 时先手选 nums[i]，后手只能是 0
         */
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = nums[i];
            dp[i][i].sec = 0;
        }

        /**
         * dp[i][j] 需要知道 dp[i + 1][j] 和 dp[i][j - 1]
         * 所以需要倒叙遍历
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 选左面i，下一步变后手，也就是 dp[i + 1][j].sec
                int left = nums[i] + dp[i + 1][j].sec;
                // 选右面j-1，下一步变后手，也就是 dp[i][j - 1].sec
                int right = nums[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    // 先手选左面时，后手变先手，也就是 dp[i + 1][j].fir
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    // 先手选右面时，后手变先手，也就是 dp[i][j - 1].fir
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        // 返回从0~n之间先手最大值 - 后手最大值
        return dp[0][n - 1].fir - dp[0][n - 1].sec;
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

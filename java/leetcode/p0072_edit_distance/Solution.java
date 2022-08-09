package leetcode.p0072_edit_distance;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros")); // 3
        System.out.println(solution.minDistance("intention", "execution")); // 5
    }

    private int[][] memo;

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String s1, int i, String s2, int j) {
        // base case 一个词走完了，剩下的替换次数=另一个词剩余的字符数
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            // skip
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            memo[i][j] = Math.min(
                    Math.min(
                            // 替换
                            1 + dp(s1, i - 1, s2, j - 1),
                            // 插入
                            1 + dp(s1, i, s2, j - 1)),
                    // 删除
                    1 + dp(s1, i - 1, s2, j));
        }
        return memo[i][j];
    }
}

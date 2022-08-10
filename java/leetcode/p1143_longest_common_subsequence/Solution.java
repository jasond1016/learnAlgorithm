package leetcode.p1143_longest_common_subsequence;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde", "ace")); // 3
        System.out.println(solution.longestCommonSubsequence("abc", "abc")); // 3
        System.out.println(solution.longestCommonSubsequence("abc", "def")); // 0
    }

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(text1, 0, text2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = max(
                    dp(s1, i, s2, j + 1),
                    dp(s1, i + 1, s2, j),
                    dp(s1, i + 1, s2, j + 1)
            );
        }

        return memo[i][j];
    }

    private int max(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}

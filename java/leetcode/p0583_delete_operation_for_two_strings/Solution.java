package leetcode.p0583_delete_operation_for_two_strings;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("sea", "eat")); // 2
        System.out.println(solution.minDistance("leetcode", "etco")); // 4
    }

    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(word1, 0, word2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        } else if (j == s2.length()) {
            return s1.length() - i;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = min(
                    dp(s1, i + 1, s2, j + 1),
                    1 + dp(s1, i, s2, j + 1),
                    1 + dp(s1, i + 1, s2, j)
            );

        } else {
            memo[i][j] = Math.min(
                    1 + dp(s1, i, s2, j + 1),
                    1 + dp(s1, i + 1, s2, j)
            );
        }
        return memo[i][j];
    }

    private int min(int x, int y, int z) {
        return Math.min(x, Math.max(y, z));
    }
}

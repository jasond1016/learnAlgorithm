package leetcode.p0712_minimum_ascii_delete_sum_for_two_strings;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumDeleteSum("sea", "eat")); // 231
        System.out.println(solution.minimumDeleteSum("delete", "leet")); // 403
    }

    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(s1, 0, s2, 0);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == s1.length()) {
            int res = 0;
            for (int k = j; k < s2.length(); k++) {
                res += s2.charAt(k);
            }
            return res;
        } else if (j == s2.length()) {
            int res = 0;
            for (int k = i; k < s1.length(); k++) {
                res += s1.charAt(k);
            }
            return res;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);

        } else {
            memo[i][j] = Math.min(
                    (int) s2.charAt(j) + dp(s1, i, s2, j + 1),
                    (int) s1.charAt(i) + dp(s1, i + 1, s2, j)
            );
        }
        return memo[i][j];
    }

    private int min(int x, int y, int z) {
        return Math.min(x, Math.max(y, z));
    }
}

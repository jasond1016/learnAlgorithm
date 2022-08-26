package leetcode.p0028_implement_strstr;

/**
 * @author Wang Botai
 * @date 2022/08/26 18:06
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll")); // 2
        System.out.println(solution.strStr("aaaaa", "bba")); // -1
    }

    public int strStr(String haystack, String needle) {
        String pat = needle;
        String txt = haystack;
        int m = pat.length();
        int n = txt.length();

        // dp[j][c] = next
        // 当前是状态 j，遇到了字符 c，应该转义到状态 next
        int[][] dp = new int[m][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 为了构建dp数组，需要辅助状态 x
        // 它永远比当前状态 j 落后一个状态，拥有和 j 最长的相同前缀
        int x = 0;
        for (int i = 1; i < m; i++) {
            for (int c = 0; c < 256; c++) {
                if (pat.charAt(i) == c) {
                    // 遇到的字符和 pat 一致，前进一步
                    dp[i][c] = i + 1;
                } else {
                    // 不一致则回退，退到哪取决于 x
                    dp[i][c] = dp[x][c];
                }
            }
            x = dp[x][pat.charAt(i)];
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            j = dp[j][txt.charAt(i)];
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}

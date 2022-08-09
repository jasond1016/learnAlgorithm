package leetcode.p0072_edit_distance;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros")); // 3
        System.out.println(solution.minDistance("intention", "execution")); // 5
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
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

        if (s1.charAt(i) == s2.charAt(j)) {
            // skip
            return dp(s1, i - 1, s2, j - 1);
        } else {
            return Math.min(
                    Math.min(
                            // 替换
                            1 + dp(s1, i - 1, s2, j - 1),
                            // 插入
                            1 + dp(s1, i, s2, j - 1)),
                    // 删除
                    1 + dp(s1, i - 1, s2, j));
        }
    }
}

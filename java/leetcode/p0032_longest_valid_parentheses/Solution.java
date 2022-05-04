package leetcode.p0032_longest_valid_parentheses;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "(()";
//        String s = ")()())";
//        String s = "";
//        String s = "()(())";
//        String s = "()(()";
        String s = "())";
        System.out.println(solution.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int maxVal = 0;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && s.charAt(i - 1) == '(') {
                dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
            } else if (c == ')' && s.charAt(i - 1) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            maxVal = Math.max(maxVal, dp[i]);
        }

        return maxVal;
    }
}

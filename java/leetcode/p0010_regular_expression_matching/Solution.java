package leetcode.p0010_regular_expression_matching;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Botai
 * @date 2022/08/22 19:06
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a")); // false
        System.out.println(solution.isMatch("aa", "a*")); // true
        System.out.println(solution.isMatch("ab", ".*")); // true
        System.out.println(solution.isMatch("baa", "ba*aa")); // true
    }

    Map<String, Boolean> memo;

    public boolean isMatch(String s, String p) {
        memo = new HashMap<>();
        return dp(s, 0, p, 0);
    }

    // dp(s,i,p,j) = true 表示s[i~]可以匹配p[j~]
    private boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        if (j == n) {
            return i == m;
        }

        if (i == m) {
            // 此时字符串 s 已匹配完，接下来要验证 p 是不是可以匹配0次
            // p 剩下的如果不是 x* 的形式，肯定为false
            if ((n - j) % 2 == 1) {
                return false;
            }

            // 验证 p 剩下的是不是 x*y*z* 的形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = "" + i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 匹配0次或多次
                memo.put(key, dp(s, i, p, j + 2) || dp(s, i + 1, p, j));
            } else {
                // 一对一匹配
                memo.put(key, dp(s, i + 1, p, j + 1));
            }
        } else {
            // 不匹配
            if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                // 匹配0次
                memo.put(key, dp(s, i, p, j + 2));
            } else {
                memo.put(key, false);
            }
        }
        return memo.get(key);
    }
}

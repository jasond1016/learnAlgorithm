package leetcode.p0080_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(1));
    }

    private List<String> res;
    /**
     * 对于一组合法括号，必满足以下两点：
     * 1. 左括号数量 = 右括号数量
     * 2. 到终点前 左括号数量 >= 右括号数量
     */
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        backtrack(sb, 0, 0, n);
        return res;
    }

    private void backtrack(StringBuffer sb, int left, int right, int limit) {
        // 不合法括号
        if (left > limit || right > limit || right > left) {
            return;
        }

        // 一组合法括号
        if (left == right && left == limit) {
            res.add(sb.toString());
            return;
        }

        // 选择 (
        sb.append("(");
        backtrack(sb, left + 1, right, limit);
        // 撤销选择 (
        sb.deleteCharAt(sb.length() - 1);

        // 选择 )
        sb.append(")");
        backtrack(sb, left, right + 1, limit);
        // 撤销选择 )
        sb.deleteCharAt(sb.length() - 1);
    }
}

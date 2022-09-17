package leetcode.p0241_different_ways_to_add_parentheses;

import java.util.*;

/**
 * Solution
 *
 * @author Jason
 * @date 2022/09/17 15:22
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2-1-1")); // [0, 2]
        System.out.println(solution.diffWaysToCompute("2*3-4*5")); // [-34, -14, -10, -10, 10]
    }

    Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> res = new ArrayList<>();
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1, n));

                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        switch (c) {
                            case '+':
                                res.add(left + right);
                                break;
                            case '-':
                                res.add(left - right);
                                break;
                            case '*':
                                res.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression));
        }
        memo.put(expression, res);
        return res;
    }
}

package leetcode.p1081_smallest_sequences_of_distinct_characters;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestSubsequence("bcabc"));
        System.out.println(solution.smallestSubsequence("bcadc"));
        // bcad
        // badc
        System.out.println(solution.smallestSubsequence("cbacdcbc"));
    }
    public String smallestSubsequence(String s) {
        // 存放去重后的字符
        Stack<Character> stack = new Stack<>();
        // 字符是否在栈
        boolean[] inStack = new boolean[256];
        // 字符出现次数
        int[] counts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)] += 1;
        }
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            counts[c] -= 1;
            if (inStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek()) {
                if (counts[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

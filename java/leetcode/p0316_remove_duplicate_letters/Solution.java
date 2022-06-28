package leetcode.p0316_remove_duplicate_letters;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bcabc"));
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution.removeDuplicateLetters("bcac"));
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
    }
    public String removeDuplicateLetters(String s) {
        // 栈中存放去重后字符
        Stack<Character> stack = new Stack<>();
        // 字符是否在栈
        boolean[] inStack = new boolean[256];
        // 字符出现次数
        int[] counts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)] += 1;
        }

        for (char c : s.toCharArray()) {
            counts[c] -= 1;
            // 跳过重复字符
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                // 如果后续没有改字符的话，要留在栈中
                if (counts[stack.peek()] == 0) {
                    break;
                }
                // 后续还有该字符，考虑到小字符序，直接出栈
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        // 栈中顺序是反的，需要倒序拼接字符串
        return sb.reverse().toString();
    }
}

package leetcode.p0151_reverse_word_in_a_string;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "  hello world  ";
        System.out.println(solution.reverseWords(s));
    }

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == ' ' && s.charAt(i) != ' ') {
                String trimStr = s.substring(index, i).trim();
                if (trimStr.isEmpty()) {
                    continue;
                }
                stack.push(trimStr);
                index = i;
            }

        }
        stack.push(s.substring(index).trim());

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : "";
    }
}

package leetcode.p0008_string_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = " ";
        System.out.println(solution.myAtoi(s));
    }

    public int myAtoi(String s) {
        Map<Character, Integer> nums = new HashMap<>();
        nums.put('0', 0);
        nums.put('1', 1);
        nums.put('2', 2);
        nums.put('3', 3);
        nums.put('4', 4);
        nums.put('5', 5);
        nums.put('6', 6);
        nums.put('7', 7);
        nums.put('8', 8);
        nums.put('9', 9);

        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        int sign = 1;
        int i = 0;
        for (; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            } else if (chars[i] == '-') {
                sign = -1;
                i++;
                break;
            } else if (chars[i] == '+') {
                i++;
                break;
            }
            break;
        }
        
        if (i >= chars.length || nums.get(chars[i]) == null) {
            return 0;
        }

        int start = i;
        int end = i;
        for (int j = i; j < chars.length; j++) {
            if (nums.get(chars[j]) == null && nums.get(chars[start]) != null) {
                break;
            }
            if (chars[j] == ' ') {
                start = j + 1;
                continue;
            }
            if (nums.get(chars[j]) != null) {
                end = j;
            }
        }

        long result = 0;
        for (int j = start; j <= end; j++) {
            result = result * 10 + nums.get(chars[j]);

            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int) result * sign;
    }
}

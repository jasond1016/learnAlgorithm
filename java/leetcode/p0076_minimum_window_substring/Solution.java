package leetcode.p0076_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
    }
    public String minWindow(String s, String t) {
        // 需要的字符及个数
        Map<Character, Integer> need = new HashMap<>();
        // 窗口中的字符及个数
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        
        // 窗口左边索引
        int left = 0;
        // 窗口右边索引
        int right = 0;
        // 满足条件的字符个数
        int valid = 0;
        // 最小覆盖字串的起始为止
        int start = 0;
        // 最小覆盖字串的长度
        int len = Integer.MAX_VALUE;
        // 当窗口右边界滑动过所有字符后循环结束
        while (right < s.length()) {
            // 将要加入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            
            // 窗口内数据更新
            if (need.containsKey(c)) {
                // 个数加1
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    // 满足条件字符数加1
                    valid++;
                }
            }

            // 判断左侧窗口是否需要收缩
            while (valid == need.size()) {
                // 更新最小字串的起始索引和长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 即将移出窗口的字符
                char d = s.charAt(left);
                left++;
                // 更新窗口内数据
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        // 满足条件字符数减1
                        valid--;
                    }
                    // 个数减1
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}

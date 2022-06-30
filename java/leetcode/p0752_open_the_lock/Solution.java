package leetcode.p0752_open_the_lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(solution.openLock(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution.openLock(deadends, "0009"));

        deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        System.out.println(solution.openLock(deadends, "8888"));
    }
    public int openLock(String[] deadends, String target) {
        // 记录 deadends
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        // 记录尝试过的组合
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int guess = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String p = queue.poll();
                
                if (deads.contains(p)) {
                    continue;
                }

                // 命中
                if (p.equals(target)) {
                    return guess;
                }

                // 将四位数字向上或向下拨动（跳过尝试过的组合）
                for (int j = 0; j < 4; j++) {
                    String u = up(p, j);
                    if (!visited.contains(u)) {
                        queue.offer(u);
                        visited.add(u);
                    }
                    String d = down(p, j);
                    if (!visited.contains(d)) {
                        queue.offer(d);
                        visited.add(d);
                    }
                }
            }
            guess++;
        }
        // 无解
        return -1;
    }

    // 将第 i 位数字向上拨
    private String up(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    // 将第 i 位数字向下拨
    private String down(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}

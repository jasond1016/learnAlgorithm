package leetcode.p0739_daily_temperatures;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
        
        temperatures = new int[]{30,40,50,60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
        
        temperatures = new int[]{30,60,90};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                // 计算间隔
                res[i] = stack.peek() - i;
            } else {
                res[i] = 0;
            }
            // 将索引入栈
            stack.push(i);
        }
        return res;
    }
}

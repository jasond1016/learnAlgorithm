package leetcode.p0503_next_greater_element_2;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,1};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums)));

        nums = new int[]{1,2,3,4,3};
        System.out.println(Arrays.toString(solution.nextGreaterElements(nums)));
    }
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        
        // 循环加倍模拟环形数组遍历
        for (int i = 2 * (n - 1); i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[i % n] = stack.peek();
            } else {
                res[i % n] = -1;
            }
            stack.push(nums[i % n]);
        }
        return res;
    }
}

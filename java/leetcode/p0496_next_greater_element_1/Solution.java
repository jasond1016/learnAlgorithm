package leetcode.p0496_next_greater_element_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums2)));

        nums1 = new int[]{2,4};
        nums2 = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(solution.nextGreaterElement(nums2)));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaterElements = nextGreaterElement(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        // 将 nums2 中所有数对应的 nextGreaterElement 存入 map
        for (int i = 0; i < nextGreaterElements.length; i++) {
            map.put(nums2[i], nextGreaterElements[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // 因为 nums1 是 nums2 的子集，所以肯定能获取到
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
    
    private int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 倒着放入栈
        for (int i = n - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 比当前数小的都出栈
                stack.pop();
            }
            if (!stack.isEmpty()) {
                // 获取到下一个比较大的数
                res[i] = stack.peek();
            } else {
                // 后面没有更大的数
                res[i] = -1;
            }
            stack.push(nums[i]);
        }
        return res;
    }
}

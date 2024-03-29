package leetcode.p1480_running_sum_of_1d_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.runningSum(nums)));
        nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(solution.runningSum(nums)));
        nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(solution.runningSum(nums)));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }
}

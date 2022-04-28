package leetcode.p0016_3sum_closet;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
//        int[] nums = new int[]{0, 0, 0};
        System.out.println(solution.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int delta = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i] + twoSumCloset(nums, i + 1, target - nums[i]);
            if (Math.abs(delta) > Math.abs(sum - target)) {
                delta = sum - target;
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return target + delta;
    }

    private int twoSumCloset(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;

        int delta = Integer.MAX_VALUE;
        while (lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            int sum = left + right;

            if (Math.abs(delta) > Math.abs(sum - target)) {
                delta = sum - target;
            }

            if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return target + delta;
    }
}

package leetcode.p0645_set_mismatch;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 2, 4};
        System.out.println(Arrays.toString(solution.findErrorNums(nums))); // [2,3]

        nums = new int[]{1, 1};
        System.out.println(Arrays.toString(solution.findErrorNums(nums))); // [1,2]

        nums = new int[]{2, 2};
        System.out.println(Arrays.toString(solution.findErrorNums(nums))); // [2,1]

        nums = new int[]{3, 2, 3, 4, 6, 5}; // 2 3 3 4 5 6
        System.out.println(Arrays.toString(solution.findErrorNums(nums))); // [3,1]
    }

    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = 0;
        int lost = 0;
        int curr = 1;
        for (int num : nums) {
            if (num > curr) {
                lost = curr;
                curr = num;
            } else if (num < curr) {
                dup = num;
                curr = num;
            }
            curr++;
        }
        if (lost == 0) {
            lost = nums.length;
        }
        return new int[]{dup, lost};
    }
}

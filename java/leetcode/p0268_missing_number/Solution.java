package leetcode.p0268_missing_number;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 0, 1};
        System.out.println(solution.missingNumber(nums));
        nums = new int[]{0, 1};
        System.out.println(solution.missingNumber(nums));
        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(solution.missingNumber(nums));
        nums = new int[]{1};
        System.out.println(solution.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i) {
                break;
            }
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        System.out.println("1: res = " + res);
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++) {
            System.out.println("2: " + i + " ^ " + nums[i] + " = " + (i ^ nums[i]));
            res ^= i ^ nums[i];
            System.out.println("3: res ^ " + (i ^ nums[i]) + " = "  + res);
        }
        return res;
    }
}

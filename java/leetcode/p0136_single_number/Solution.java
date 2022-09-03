package leetcode.p0136_single_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 1};
        System.out.println(solution.singleNumber(nums)); // 1

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums)); // 4

        nums = new int[]{1};
        System.out.println(solution.singleNumber(nums)); // 1
    }

    /**
     * a ^ a = 0
     * a ^ 0 = a
     * 所以对 nums 反复做异或操作，最后剩下的数字就是 single number（成对的会变成0）
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }
}

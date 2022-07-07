package leetcode.p0213_house_robber_2;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,2};
        System.out.println(solution.rob(nums)); // 3

        nums = new int[]{1,2,3,1};
        System.out.println(solution.rob(nums)); // 4

        nums = new int[]{1,2,3};
        System.out.println(solution.rob(nums)); // 3

        nums = new int[]{1};
        System.out.println(solution.rob(nums)); // 3
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }
        // 首尾不能同时抢的话，分两种情况（钱是非负整数，所以首尾都不抢可以直接排除掉）
        return Math.max(
                // 抢首不抢尾
                robRange(nums, 0, n - 2),
                // 抢尾不抢首
                robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int from, int to) {
        int dpi = 0;
        int dp1 = 0;
        int dp2 = 0;

        for (int i = to; i >= from; i--) {
            dpi = Math.max(dp1, nums[i] + dp2);
            dp2 = dp1;
            dp1 = dpi;
        }

        return dpi;
    }
}

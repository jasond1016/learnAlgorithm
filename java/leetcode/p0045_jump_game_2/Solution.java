package leetcode.p0045_jump_game_2;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums)); // 2

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums)); // 2

        nums = new int[]{1};
        System.out.println(solution.jump(nums)); // 0
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (x > 0) {
                int index = x + i;
                if (index > n - 1) {
                    x--;
                    continue;
                }
                dp[index] = Math.min(dp[index], dp[i] + 1);
                x--;
            }
        }
        return dp[n - 1];
    }
}

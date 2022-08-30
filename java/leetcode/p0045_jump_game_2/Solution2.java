package leetcode.p0045_jump_game_2;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums)); // 2

        nums = new int[]{2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums)); // 2

        nums = new int[]{1};
        System.out.println(solution.jump(nums)); // 0
    }

    public int jump(int[] nums) {
        int n = nums.length;
        // farthest 是 i ~ end 之间能跳的最远距离，res记录了跳跃次数
        int farthest = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if (end == i) {
                res++;
                end = farthest;
            }
        }
        return res;
    }
}

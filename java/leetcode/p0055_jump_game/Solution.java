package leetcode.p0055_jump_game;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(solution.canJump(nums)); // true

        nums = new int[]{3,2,1,0,4};
        System.out.println(solution.canJump(nums)); // false
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 计算跳到最远的索引
            farthest = Math.max(farthest, nums[i] + i);
            if (farthest <= i) {
                // 跳不动了
                return false;
            }
        }
        return farthest >= n - 1;
    }
}

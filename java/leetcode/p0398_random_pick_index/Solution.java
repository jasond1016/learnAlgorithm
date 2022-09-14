package leetcode.p0398_random_pick_index;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution solution = new Solution(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(2));
    }

    private Random random;
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index++;
                if (0 == random.nextInt(index)) {
                    res = i;
                }
            }
        }
        return res;
    }
}

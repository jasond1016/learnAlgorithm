package leetcode.p0494_target_sum;

/**
 * @author Wang Botai
 * @date 2022/08/16 18:25
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target)); // 5

        nums = new int[]{1};
        target = 1;
        System.out.println(solution.findTargetSumWays(nums, target)); // 1
    }

    int result;

    public int findTargetSumWays(int[] nums, int target) {
        result = 0;
        backtrack(nums, 0, target);
        return result;
    }

    private void backtrack(int[] nums, int i, int remain) {
        if (i == nums.length) {
            if (remain == 0) {
                result++;
            }
            return;
        }

        remain -= nums[i];
        backtrack(nums, i + 1, remain);
        remain += nums[i];

        remain += nums[i];
        backtrack(nums, i + 1, remain);
        remain -= nums[i];
    }
}

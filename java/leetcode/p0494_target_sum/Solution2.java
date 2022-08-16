package leetcode.p0494_target_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Botai
 * @date 2022/08/16 18:52
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution.findTargetSumWays(nums, target)); // 5

        nums = new int[]{1};
        target = 1;
        System.out.println(solution.findTargetSumWays(nums, target)); // 1
    }


    Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, 0, target);
    }

    private int dp(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        String k = i + "," + target;
        if (memo.containsKey(k)) {
            return memo.get(k);
        }

        k = i + "," + target;
        int result = dp(nums, i + 1, target - nums[i]) +
                dp(nums, i + 1, target + nums[i]);
        memo.put(k, result);

        return result;
    }
}

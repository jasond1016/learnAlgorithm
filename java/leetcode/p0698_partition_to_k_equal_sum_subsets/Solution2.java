package leetcode.p0698_partition_to_k_equal_sum_subsets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(solution.canPartitionKSubsets(nums, k)); // true

        nums = new int[]{1, 2, 3, 4};
        k = 3;
        System.out.println(solution.canPartitionKSubsets(nums, k)); // false
    }

    private Map<Integer, Boolean> memo;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除掉几种不可能的情况
        if (k > nums.length) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }

        // 使用位运算记录每个数是否放到桶里
        int used = 0;
        // 如果能平分，则各桶合计应为 target
        int target = sum / k;

        memo = new HashMap<>();
        return backtrack(k, nums, 0, 0, used, target);
    }

    // nums[start]是否应该装进桶 k，桶 k 当前合计为 bucket，已经使用过的数为 used
    private boolean backtrack(int k, int[] nums, int start, int bucket, int used, int target) {
        if (k == 0) {
            // 所有桶都装满了，并且 nums 一定是用完了
            return true;
        }

        if (bucket == target) {
            // 当前桶装满了，递归尝试下一个桶
            boolean res =  backtrack(k - 1, nums, 0, 0, used, target);
            memo.put(used, res);
            return res;
        }

        if (memo.containsKey(used)) {
            return memo.get(used);
        }

        for (int i = start; i < nums.length; i++) {
            // 剪枝：用过的数不能再用
            if (((used >> i) & 1) == 1) {
                // 第 i 位数字是否用过（== 1）
                continue;
            }
            // 剪枝：桶中数之和超过 target
            if (bucket + nums[i] > target) {
                continue;
            }

            // 做选择
            used |= 1 << i;
            bucket += nums[i];
            // 递归判断下个数是否应该装进桶 k
            if (backtrack(k, nums, i + 1, bucket, used, target)) {
                return true;
            }
            // 撤销选择
            used ^= 1 << i;
            bucket -= nums[i];
        }
        return false;
    }
}

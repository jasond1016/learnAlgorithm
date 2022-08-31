package leetcode.p0698_partition_to_k_equal_sum_subsets;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(solution.canPartitionKSubsets(nums, k)); // true

        nums = new int[]{1, 2, 3, 4};
        k = 3;
        System.out.println(solution.canPartitionKSubsets(nums, k)); // false
    }

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

        // bucket[i] = 装到 i 桶中的数之和
        int[] bucket = new int[k];
        // 如果能平分，则各桶合计应为 target
        int target = sum / k;
        return backtrack(nums, 0, bucket, target);
    }

    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        if (nums.length == index) {
            // 遍历到最后一个数，判定结果
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < bucket.length; i++) {
            // 剪枝：桶中数之和超过 target
            if (bucket[i] + nums[index] > target) {
                continue;
            }
            // 做选择
            bucket[i] += nums[index];
            // 遍历下个数
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }
            // 撤销选择
            bucket[i] -= nums[index];
        }
        return false;
    }
}

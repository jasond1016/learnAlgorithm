package leetcode.p0152_maximum_product_subarray;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
        nums = new int[]{-2, 0, -1};
        System.out.println(solution.maxProduct(nums));
        nums = new int[]{-2};
        System.out.println(solution.maxProduct(nums));
        nums = new int[]{0, 2};
        System.out.println(solution.maxProduct(nums));
        nums = new int[]{-2, 3, -4};
        System.out.println(solution.maxProduct(nums));
        nums = new int[]{-4, -3, -2};
        System.out.println(solution.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(temp * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            if (max > res) {
                res = max;
            }
        }
        return res;
    }

}

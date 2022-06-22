package leetcode.p0704_binary_search;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums, 9));

        nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(solution.search(nums, 2));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

package leetcode.p0027_remove_element;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(solution.removeElement(nums, 3));
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(solution.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}

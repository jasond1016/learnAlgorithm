package leetcode.p0169_majority_element;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{3,2,3};
//        int[] nums = new int[]{2,2,1,1,1,2,2};
        int[] nums = new int[]{2, 2, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6};

        System.out.println(solution.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Boyer-Moore Voting Algorithm
    // Time: O(n) Space: O(1)
    public int majorityElement2(int[] nums) {
        int n = nums.length;
        Integer candicate = null;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candicate = nums[i];
            }
            count += candicate == nums[i] ? 1 : -1;
        }
        return candicate;
    }
}

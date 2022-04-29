package leetcode.p0041_first_missing_positive;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{1, 2, 0};
        int[] nums = new int[]{3,4,-1,1};
//        int[] nums = new int[]{7,8,9,11,12};
//        int[] nums = new int[]{2,1};
        System.out.println(solution.firstMissingPositive2(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                continue;
            }

            map.putIfAbsent(nums[i], nums[i]);
        }

        
        while (true) {
            if (map.get(result) != null) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] -1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

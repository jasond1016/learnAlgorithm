package leetcode.p0229_majority_element_2;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{3, 2, 3};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2};
//        int[] nums = new int[]{2, 2, 1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6};

        System.out.println(solution.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int limit = n / 3;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        map.forEach((k, v) -> {
            if (v > limit) {
                result.add(k);
            }
        });
        return result;
    }
}

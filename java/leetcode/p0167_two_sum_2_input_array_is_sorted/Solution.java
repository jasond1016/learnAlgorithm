package leetcode.p0167_two_sum_2_input_array_is_sorted;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(solution.twoSum(numbers, 9)));
        numbers = new int[]{2,3,4};
        System.out.println(Arrays.toString(solution.twoSum(numbers, 6)));
        numbers = new int[]{-1,0};
        System.out.println(Arrays.toString(solution.twoSum(numbers, -1)));
    }
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{-1, -1};
    }
}

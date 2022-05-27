package leetcode.p0912_sort_an_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
        nums = new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        sort(nums, temp, 0, n - 1);
        return nums;
    }

    private void sort(int[] nums, int[] res, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        
        int mid = lo + (hi - lo) / 2;
        sort(nums, res, lo, mid);
        sort(nums, res, mid + 1, hi);
        merge(nums, res, lo, mid, hi);
    }

    private void merge(int[] nums, int[] res, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            res[i] = nums[i];
        }
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                nums[k] = res[j++];
            } else if (j > hi) {
                nums[k] = res[i++];
            } else if (res[i] < res[j]) {
                nums[k] = res[i++];
            } else {
                nums[k] = res[j++];
            }
        }

    }
}

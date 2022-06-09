package leetcode.p0215_kth_largest_element_in_an_array;

import java.util.Random;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
        nums = new int[]{3, 3, 3, 3, 3, 3};
        System.out.println(solution.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return nums[lo];
        }

        int p = partition(nums, lo, hi);
        if (p > nums.length - k) {
            return findKthLargest(nums, lo, p - 1, k);
        } else if (p < nums.length - k) {
            return findKthLargest(nums, p + 1, hi, k);
        } else {
            return nums[p];
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        int pivot = nums[lo];
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) {
                i++;
            }
            while (j > lo && nums[j] > pivot) {
                j--;
            }

            if (i >= j) {
                break;
            }

            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }
}

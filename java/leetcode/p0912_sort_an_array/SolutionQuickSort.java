package leetcode.p0912_sort_an_array;

import java.util.Arrays;
import java.util.Random;

public class SolutionQuickSort {
    public static void main(String[] args) {
        SolutionQuickSort solution = new SolutionQuickSort();
        int[] nums = new int[]{5,2,3,1};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
        nums = new int[]{5,1,1,2,0,0};
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        shuffle(nums);
        sort(nums, 0, n - 1);
        return nums;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int p = partition(nums, lo, hi);
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= nums[lo]) {
                i++;
            }
            while (j > lo && nums[j] > nums[lo]) {
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
            int x = random.nextInt(i + 1);
            swap(nums, i, x);
        }
    }
}

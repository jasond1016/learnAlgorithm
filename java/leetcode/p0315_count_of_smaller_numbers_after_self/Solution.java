package leetcode.p0315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 2, 6, 1};
        System.out.println(solution.countSmaller(nums));
        nums = new int[]{1, 2, 0};
        System.out.println(solution.countSmaller(nums));
        nums = new int[]{1, 9, 7, 8, 5};
        System.out.println(solution.countSmaller(nums));
    }

    private Pair[] temp;
    private int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        temp = new Pair[nums.length];
        counts = new int[nums.length];
        Pair[] arr = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, nums.length - 1);

        List<Integer> res = new ArrayList<>();
        for (int c : counts) res.add(c);
        return res;
    }

    private void sort(Pair[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            temp[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = temp[j++];
            } else if (j > hi) {
                arr[k] = temp[i++];
                counts[arr[k].index] += j - mid - 1;
            } else if (temp[i].val > temp[j].val) {
                arr[k] = temp[j++];
            } else {
                arr[k] = temp[i++];
                counts[arr[k].index] += j - mid - 1;
            }
        }
    }

    private class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}

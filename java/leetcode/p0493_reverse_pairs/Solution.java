package leetcode.p0493_reverse_pairs;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 2, 3, 1};
        System.out.println(solution.reversePairs(nums));
        nums = new int[]{2, 4, 3, 5, 1};
        System.out.println(solution.reversePairs(nums));
        nums = new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(solution.reversePairs(nums));
    }

    private int count = 0;
    private int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        count = 0;
        sort(nums, 0, nums.length - 1);
        return count;
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        for (int j = mid + 1; j <= hi; j++) {
            int i = lo;
            while (i <= mid) {
                if (arr[i] > 2L * arr[j]) {
                    count += mid + 1 - i;
                    break;
                }
                i++;
            }

        }
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
            } else if (temp[i] > temp[j]) {
                arr[k] = temp[j++];
            } else {
                arr[k] = temp[i++];
            }
        }
    }
}

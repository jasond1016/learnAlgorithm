package leetcode.p0327_count_of_range_sum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2, 5, -1};
        System.out.println(solution.countRangeSum(nums, -2, 2));
        nums = new int[]{0};
        System.out.println(solution.countRangeSum(nums, 0, 0));

    }

    private long[] preSum;
    private int lower;
    private int upper;
    private long[] temp;
    private int count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        preSum = new long[nums.length + 1];
        temp = new long[nums.length + 1];
        count = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }

        this.lower = lower;
        this.upper = upper;
        sort(preSum, 0, preSum.length - 1);
        return count;
    }

    private void sort(long[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private void merge(long[] arr, int lo, int mid, int hi) {

//        for (int i = lo; i <= mid; i++) {
//            for (int j = mid + 1; j <= hi; j++) {
//                long result = preSum[j] - preSum[i];
//                if (result >= lower && result <= upper) {
//                    count++;
//                }
//            }
//        }

        int start = mid + 1;
        int end = mid + 1;
        for (int i = lo; i <= mid; i++) {
            while (start <= hi && arr[start] - arr[i] < lower) {
                start++;
            }
            while (end <= hi && arr[end] - arr[i] <= upper) {
                end++;
            }
            count += end - start;
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

package leetcode.p1109_corporate_flight_bookings;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] bookings = new int[][]{
                {1, 2, 10}, {2, 3, 20}, {2, 5, 25}
        };
        System.out.println(Arrays.toString(solution.corpFlightBookings(bookings, 5)));
        
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        for (int[] booking : bookings) {
            difference.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return difference.result();
    }

    class Difference {
        private int[] diffs;

        public Difference(int[] nums) {
            diffs = new int[nums.length];
            diffs[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diffs[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diffs[i] += val;
            if (j + 1 < diffs.length) {
                diffs[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diffs.length];
            res[0] = diffs[0];
            for (int i = 1; i < diffs.length; i++) {
                res[i] = res[i - 1] + diffs[i];
            }
            return res;
        }
    }
}

package leetcode.p1094_car_pooling;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] trips = new int[][]{
                {2,1,5},
                {3,3,7}
        };
        System.out.println(solution.carPooling(trips, 4));
        System.out.println(solution.carPooling(trips, 5));

        trips = new int[][]{
                {2,1,5},
                {3,5,7}
        };
        System.out.println(solution.carPooling(trips, 3));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        // array capacity based on problem constraints
        int[] nums = new int[1001];
        Difference difference = new Difference(nums);
        for (int[] trip : trips) {
            difference.increment(trip[1], trip[2] - 1, trip[0]);
        }
        int[] result = difference.result();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
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

package leetcode.p0370_range_addition;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] updates = new int[][]{
                {1,3,2},
                {2,4,3},
                {0,2,-2}
        };
        System.out.println(Arrays.toString(solution.getModifiedArray(5, updates)));
    }
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            difference.increment(i, j, val);
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

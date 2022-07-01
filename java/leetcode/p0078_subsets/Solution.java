package leetcode.p0078_subsets;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.subsets(nums));

        nums = new int[]{0};
        System.out.println(solution.subsets(nums));
    }

    List<List<Integer>> res;
    LinkedList<Integer> track;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {

        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}

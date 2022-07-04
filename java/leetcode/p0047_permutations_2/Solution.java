package leetcode.p0047_permutations_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,2};
        System.out.println(solution.permuteUnique(nums));

        nums = new int[]{1,2,3};
        System.out.println(solution.permuteUnique(nums));
    }

    List<List<Integer>> res;
    LinkedList<Integer> track;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        used = new boolean[nums.length];
        // 相同元素排在一起
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件1
            if (used[i]) {
                continue;
            }

            // 剪枝条件2
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 如果前面的相邻相等元素没有用过，则跳过
                continue;
            }

            used[i] = true;
            track.addLast(nums[i]);
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}

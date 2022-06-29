package leetcode.p0046_permutations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3};
        System.out.println(solution.permute(nums));

        nums = new int[]{0,1};
        System.out.println(solution.permute(nums));

        nums = new int[]{1};
        System.out.println(solution.permute(nums));
    }

    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(track, nums, used);
        return res;
    }

    private void backtrack(LinkedList<Integer> track, int[] nums, boolean[] used) {
        // 终止条件：路径长度 == 数字总个数
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 遍历 nums 中没有被选择过的数字
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 前序做选择
            track.add(nums[i]);
            used[i] = true;
            backtrack(track, nums, used);
            // 后续撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}

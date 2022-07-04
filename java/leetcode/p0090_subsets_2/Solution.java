package leetcode.p0090_subsets_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,2};
        System.out.println(solution.subsetsWithDup(nums));

        nums = new int[]{0};
        System.out.println(solution.subsetsWithDup(nums));
    }

    List<List<Integer>> res;
    LinkedList<Integer> track;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        // 排序让相同元素排在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝：值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }
}

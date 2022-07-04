package leetcode.p0040_combination_sum_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(solution.combinationSum2(candidates, target));

        candidates = new int[]{2,5,2,1,2};
        target = 5;
        System.out.println(solution.combinationSum2(candidates, target));
    }

    List<List<Integer>> res;
    LinkedList<Integer> track;
    // 记录和
    int trackSum;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        trackSum = 0;
        // 排序让相同元素排在一起
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int tartget, int start) {
        // base case
        if (trackSum == tartget) {
            res.add(new LinkedList<>(track));
            return;
        }
        
        if (trackSum > tartget) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.addLast(candidates[i]);
            trackSum += candidates[i];
            backtrack(candidates, tartget, i + 1);
            track.removeLast();
            trackSum -= candidates[i];
        }
    }
}

package leetcode.p0039_combination_sum;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[]{2, 3, 5};
        target = 8;
        System.out.println(solution.combinationSum(candidates, target));

        candidates = new int[]{2};
        target = 1;
        System.out.println(solution.combinationSum(candidates, target));
    }

    List<List<Integer>> res;
    LinkedList<Integer> track;
    int trackSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new LinkedList<>();
        track = new LinkedList<>();
        trackSum = 0;
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        // base case 1
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        
        // base case 2
        if (trackSum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            track.addLast(candidates[i]);
            trackSum += candidates[i];
            // 可以无限次重复使用某个数字，所以这里传 i 而不是 i + 1
            backtrack(candidates, target, i);
            trackSum -= candidates[i];
            track.removeLast();
        }
    }
}

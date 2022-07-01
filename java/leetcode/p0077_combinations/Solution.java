package leetcode.p0077_combinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
        System.out.println(solution.combine(1, 1));
    }

    LinkedList<Integer> track;
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        track = new LinkedList<>();
        res = new LinkedList<>();
        backtrack(1, n, k);
        return res;
    }

    private void backtrack(int start, int n, int k) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}

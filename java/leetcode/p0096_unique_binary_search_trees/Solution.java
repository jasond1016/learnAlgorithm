package leetcode.p0096_unique_binary_search_trees;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(5));
    }

    int[][] memo;
    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return countTrees(1, n);
    }

    private int countTrees(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }

        if (memo[lo][hi] > 0) {
            return memo[lo][hi];
        }
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = countTrees(lo, i - 1);
            int right = countTrees(i + 1, hi);
            res += left * right;
            
        }
        memo[lo][hi] = res;
        return res;
    }
}

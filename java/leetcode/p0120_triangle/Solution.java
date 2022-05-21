package leetcode.p0120_triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(solution.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int memoSize = (1 + m) * m / 2;
        int[] memo = new int[memoSize];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dfs(triangle, 0, 0, m, memo);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int m, int[] memo) {
        if (i >= m) {
            return 0;
        }
        int index = (1 + i) * i / 2 + j;
        if (memo[index] > Integer.MIN_VALUE) {
            return memo[index];
        }

        int curr = triangle.get(i).get(j);
        int left = dfs(triangle, i + 1, j, m, memo);
        int right = dfs(triangle, i + 1, j + 1, m, memo);
        memo[index] = curr + Math.min(left, right);
        return memo[index];
    }
}

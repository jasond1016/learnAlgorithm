package leetcode.p0514_freedom_trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Wang Botai
 * @date 2022/08/18 20:54
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String ring = "godding";
        String key = "gd";
        System.out.println(solution.findRotateSteps(ring, key)); // 4

        ring = "godding";
        key = "godding";
        System.out.println(solution.findRotateSteps(ring, key)); // 13
    }

    HashMap<Character, List<Integer>> map;
    int[][] memo;

    public int findRotateSteps(String ring, String key) {
        memo = new int[ring.length()][key.length()];
        map = new HashMap<>();
        for (int i = 0; i < ring.toCharArray().length; i++) {
            char c = ring.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        return dp(ring, 0, key, 0);
    }

    // 
    private int dp(String ring, int i, String key, int j) {
        // base case
        if (j == key.length()) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int n = ring.length();
        int res = Integer.MAX_VALUE;
        for (int k : map.get(key.charAt(j))) {
            int delta = Math.abs(i - k);
            delta = Math.min(delta, n - delta);
            int subProblem = dp(ring, k, key, j + 1);
            res = Math.min(res, 1 + delta + subProblem);
        }
        memo[i][j] = res;
        return res;
    }
}

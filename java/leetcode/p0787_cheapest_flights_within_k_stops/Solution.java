package leetcode.p0787_cheapest_flights_within_k_stops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Wang Botai
 * @date 2022/08/19 19:26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200},
        };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 700

        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        k = 1;
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 200

        n = 3;
        flights = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500},
        };
        src = 0;
        dst = 2;
        k = 0;
        System.out.println(solution.findCheapestPrice(n, flights, src, dst, k)); // 500
    }

    // to -> {from, price}
    HashMap<Integer, List<int[]>> indegree;
    int src;
    int dst;
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        this.src = src;
        this.dst = dst;
        indegree = new HashMap<>();
        memo = new int[n][k + 1];
        for (int[] m : memo) {
            Arrays.fill(m, -888);
        }
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            indegree.putIfAbsent(to, new ArrayList<>());
            indegree.get(to).add(new int[]{from, price});
        }
        return dp(dst, k);
    }

    /**
     * 定义：从 src 出发，k 步之内到达 s 的最小成本
     */
    private int dp(int s, int k) {
        if (src == s) {
            return 0;
        }

        if (k == 0) {
            return -1;
        }

        if (memo[s][k] != -888) {
            return memo[s][k];
        }

        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                int subProblem = dp(from, k - 1);
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}

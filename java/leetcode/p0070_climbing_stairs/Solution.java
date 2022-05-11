package leetcode.p0070_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(45));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (map.get(n) != null) {
            return map.get(n);
        }

        int result = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, result);

        return result;
    }
}

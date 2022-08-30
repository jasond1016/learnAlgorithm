package leetcode.p0134_gas_station;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // 3

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // -1
    }


    /**
     * 贪心解法基于以下结论：
     * 如果从 i 恰好无法到达 j（可以到达j - 1），那么 i ~ j之间的任一 k 都不可能作为起点
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // sum(gas) - sum(cost)
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0) {
            // 总油量 < 总耗费，无法走完全程
            return -1;
        }

        // current tank
        int tank = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // 如果油量 < 0，无法从 start 到达 i + 1，start ~ i + 1都可以排除掉
                tank = 0;
                start = i + 1;
            }
        }

        return start == n ? 0 : start;
    }
}

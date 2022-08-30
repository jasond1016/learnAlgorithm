package leetcode.p0134_gas_station;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // 3

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // -1
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // sum(gas) - sum(cost)
        int sum = 0;
        // minimum of sum
        int minSum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                // 找到最小的合计值作为起点（需要+1）
                minSum = sum;
                res = i + 1;
            }
        }

        if (sum < 0) {
            // 总油量 < 总耗费，无法走完全程
            return -1;
        }

        return res == n ? 0 : res;
    }
}

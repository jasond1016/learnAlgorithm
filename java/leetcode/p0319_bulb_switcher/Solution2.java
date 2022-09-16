package leetcode.p0319_bulb_switcher;

/**
 * Solution
 *
 * @author Jason
 * @date 2022/09/16 19:23
 **/
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.bulbSwitch(0)); // 0
        System.out.println(solution.bulbSwitch(1)); // 1
        System.out.println(solution.bulbSwitch(2)); // 1
        System.out.println(solution.bulbSwitch(3)); // 1
        System.out.println(solution.bulbSwitch(6)); // 2
        System.out.println(solution.bulbSwitch(100000000)); // 10000
    }

    // Time Limit Exceeded
//    public int bulbSwitch(int n) {
//        boolean[] bulbs = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            bulbs[i] = true;
//        }
//
//        for (int i = 1; i < n; i = i + 2) {
//            bulbs[i] = false;
//        }
//
//        for (int i = 2; i < n; i++) {
//            for (int j = i; j < n; j = j + i + 1) {
//                bulbs[j] = !bulbs[j];
//            }
//        }
//
//        int res = 0;
//        for (int i = 0; i < n; i++) {
//            if (bulbs[i]) {
//                res++;
//            }
//        }
//        return res;
//    }

    // Time Limit Exceeded
    public int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            dp[1] = dp[2];
            double temp = Math.sqrt(i);
            dp[2] = dp[1] + (temp == Math.floor(temp) ? 1 : 0);

        }
        return dp[2];
    }
}

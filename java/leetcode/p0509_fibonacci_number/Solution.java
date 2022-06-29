package leetcode.p0509_fibonacci_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
    }
    
    // recursive
//    public int fib(int n) {
//        if (n == 0 || n == 1) {
//            return n;
//        }
//        return fib(n - 2) + fib(n - 1);
//    }

    // dp
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }

        return dp[2];
    }
}

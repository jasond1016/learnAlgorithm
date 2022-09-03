package leetcode.p0191_number_of_1_bits;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingWeight(521)); // 3
        System.out.println(solution.hammingWeight(2097152)); // 1
        System.out.println(solution.hammingWeight(-3)); // 31
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // n & n -1 会把最后一个 1 变为 0
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}

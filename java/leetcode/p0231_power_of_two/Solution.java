package leetcode.p0231_power_of_two;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(1)); // true
        System.out.println(solution.isPowerOfTwo(16)); // true
        System.out.println(solution.isPowerOfTwo(3)); // false
    }
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        // 如果一个数是 2 的幂，那么它的二进制表示一定只有一个 1
        return (n & (n - 1)) == 0;
    }
}

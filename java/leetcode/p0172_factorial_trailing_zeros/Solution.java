package leetcode.p0172_factorial_trailing_zeros;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trailingZeroes(3)); // 0
        System.out.println(solution.trailingZeroes(5)); // 1
        System.out.println(solution.trailingZeroes(0)); // 0
    }

    /**
     * 阶乘结果有多少 0 取决于因子中有多少组 2 * 5
     * 每个偶数都存在因子 2，所以因子 2 的个数一定大于因子 5 的个数，也就是说可以只看有多少个因子 5 即可
     * n / 5 = x 表示有多少数可以提供一个因子 5
     * n / 5 / 5 = y 表示还有多少数可以再提供一个因子 5
     * n / 5 / 5 / 5 = z 表示还有多少数可以再提供一个因子 5
     * ...
     */
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (n / divisor > 0) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}

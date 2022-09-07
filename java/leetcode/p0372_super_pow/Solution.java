package leetcode.p0372_super_pow;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.superPow(2, new int[]{3})); // 8
        System.out.println(solution.superPow(2, new int[]{1,0})); // 1024
        System.out.println(solution.superPow(1, new int[]{4,3,3,8,5,2})); // 1
    }

    private static final int BASE = 1337;
    /**
     * 1. a^433852 = a^2 * a^433850 = a^2 * (a^43385)^10
     * 2. (a * b) % k = (a % k) * (b % k) % k
     */
    public int superPow(int a, int[] b) {
        int n = b.length;
        if (n == 0) {
            return 1;
        }

        int last = b[n - 1];

        int part1 = myPow(a, last);

        int[] newB = new int[n - 1];
        System.arraycopy(b, 0, newB, 0, n - 1);
        int part2 = myPow(superPow(a, newB), 10);
        return (part1 * part2) % BASE;
    }

    /**
     * return x^y % BASE
     */
    private int myPow2(int x, int y) {
        x %= BASE;
        int res = 1;
        for (int i = 0; i < y; i++) {
            res *= x;
            res %= BASE;
        }
        return res;
    }

    private int myPow(int x, int y) {
        if (y == 0) {
            return 1;
        }

        x %= BASE;

        if (y % 2 == 1) {
            // 奇数幂
            return (x * myPow(x, y - 1)) % BASE;
        } else {
            // 偶数幂
            int sub = myPow(x, y / 2);
            return (sub * sub) % BASE;
        }
    }
}

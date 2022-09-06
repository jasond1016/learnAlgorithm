package leetcode.p0204_count_primes;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10)); // 4
        System.out.println(solution.countPrimes(0)); // 0
        System.out.println(solution.countPrimes(1)); // 0
    }

    /**
     * 如果 2 是质数，那么 2 * 2, 2 * 3, 2 * 4 ... 都不是质数
     * 如果 3 是质数，那么 3 * 2, 3 * 3, 3 * 4 ... 都不是质数
     * 如果 5 是质数，那么 5 * 2, 5 * 3, 5 * 4 ... 都不是质数（注意4不是质数已经在遍历 2 时确定了）
     */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        // 优化1：遍历到 sqrt(n)即可，后面是镜像
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                // 优化2：从 i * i 开始遍历即可，因为对于 i = 5， 2i, 3i, 4i 在遍历 2,3,4 是已经设置为 false
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }

        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
}

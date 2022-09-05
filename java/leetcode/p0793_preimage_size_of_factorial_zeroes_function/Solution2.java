package leetcode.p0793_preimage_size_of_factorial_zeroes_function;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.preimageSizeFZF(0)); // 5
        System.out.println(solution.preimageSizeFZF(5)); // 0
        System.out.println(solution.preimageSizeFZF(3)); // 5
    }

    /**
     * 和解法 1 相比有两点优化：
     * hi 用 5 * 10e9
     * 普通二分查找即可，因为结果要么是 0，要么是 5
     */
    public int preimageSizeFZF(int k) {
        return binarySearch(k);
    }

    private long trailingZeroes(long n) {
        long res = 0;
        long divisor = 5;
        while (n / divisor > 0) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }

    private int binarySearch(long k) {
        long lo = 0;
        long hi = 5000000000L;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                return 5;
            }
        }
        return 0;
    }
}

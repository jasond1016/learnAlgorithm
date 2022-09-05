package leetcode.p0793_preimage_size_of_factorial_zeroes_function;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.preimageSizeFZF(0)); // 5
        System.out.println(solution.preimageSizeFZF(5)); // 0
        System.out.println(solution.preimageSizeFZF(3)); // 5
    }
    public int preimageSizeFZF(int k) {
        long right = rightBound(k);
        long left = leftBound(k);
        return (int) (right - left + 1);
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

    private long leftBound(long k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private long rightBound(long k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }
}

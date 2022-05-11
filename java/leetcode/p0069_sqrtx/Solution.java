package leetcode.p0069_sqrtx;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(1));
        System.out.println(solution.mySqrt(6));
        System.out.println(solution.mySqrt(9));
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        double delta = 0.00001;
        double start = 0.0;
        double end = x;
        double attempt = start;
        while (start <= end) {
            attempt = (start + end) / 2.0;
            double result = attempt * attempt - x;
            if (Math.abs(result) <= delta) {
                break;
            }
            if (result > delta) {
                end = attempt;
            } else if (result < 0 && Math.abs(result) > delta) {
                start = attempt;
            }
        }

        return (int) Math.floor(attempt);
    }

    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
package leetcode.p1342_number_of_steps_to_reduce_a_number_to_zero;

public class Solution {
    //    Given an integer num, return the number of steps to reduce it to zero.
//    In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSteps2(14));
        System.out.println(solution.numberOfSteps2(8));
        System.out.println(solution.numberOfSteps2(123));
    }

    public int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        if (num == 2) {
            return 2;
        }
        return 1 + (num % 2 == 0 ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
    }

    public int numberOfSteps2(int num) {
        int res = 0;

        while (num > 0) {
            res++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }
        return res;
    }
}

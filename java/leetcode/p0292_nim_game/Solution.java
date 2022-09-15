package leetcode.p0292_nim_game;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canWinNim(4)); // false
        System.out.println(solution.canWinNim(1)); // true
        System.out.println(solution.canWinNim(2)); // true
        System.out.println(solution.canWinNim(5)); // true
        System.out.println(solution.canWinNim(1348820612)); // false
    }

    // 1 ~ 3 true
    // 4 false
    // 5 true
    // 6 true
    // 7 true
    // 8 false
    // 9 true
    // 10 true
    // 11 true
    // 12 false
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}


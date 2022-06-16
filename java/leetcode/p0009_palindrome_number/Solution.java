package leetcode.p0009_palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));

        System.out.println(solution.isPalindrome2(121));
        System.out.println(solution.isPalindrome2(-121));
        System.out.println(solution.isPalindrome2(10));

    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        int left = len % 2 == 0 ? len / 2 - 1 : len / 2;
        int right = len / 2;

        while (left >= 0 && right < len) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int curr = x;
        int y = 0;
        while (Math.abs(curr) > 0) {
            int mod = curr % 10;
            y = y * 10 + mod;
            curr = curr / 10;
        }
        return x == y;
    }

}

package leetcode.p0009_palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
        
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
    
    
    
}

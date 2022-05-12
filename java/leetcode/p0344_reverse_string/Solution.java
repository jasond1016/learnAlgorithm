package leetcode.p0344_reverse_string;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s);
        
    }
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n / 2; i++) {
            swap(s, i, n - i - 1);
        }
    }

    private void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}

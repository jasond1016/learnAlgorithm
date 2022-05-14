package leetcode.p0005_longest_palindromic_substring;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("babdbab"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("ac"));
        System.out.println(solution.longestPalindrome("azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String result = "";
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]));

                if (dp[i][j] && j - i + 1 > result.length()) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        return result;
    }

}

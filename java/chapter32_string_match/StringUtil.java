package chapter32_string_match;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
    public static void main(String[] args) {
        System.out.println(StringUtil.bfFind("abcdefg", "ac"));
        System.out.println(StringUtil.bfFind("abcdefg", "abcdefg"));
        System.out.println(StringUtil.bfFind("abcdefg", "abcdef"));
        System.out.println(StringUtil.bfFind("abcdefg", "bcdefg"));
        System.out.println(StringUtil.bfFind("abcdefg", "cde"));
        System.out.println(StringUtil.bfFind("abcdefg", "g"));
        System.out.println(StringUtil.bfFind("abcdefg", ""));
        System.out.println(StringUtil.bfFind("", "a"));
        System.out.println(StringUtil.bfFind("", ""));
        System.out.println(StringUtil.rkFind("c", "c"));

        System.out.println("----");

        System.out.println(StringUtil.rkFind("abcdefg", "ac"));
        System.out.println(StringUtil.rkFind("abcdefg", "abcdefg"));
        System.out.println(StringUtil.rkFind("abcdefg", "abcdef"));
        System.out.println(StringUtil.rkFind("abcdefg", "bcdefg"));
        System.out.println(StringUtil.rkFind("abcdefg", "cde"));
        System.out.println(StringUtil.rkFind("abcdefg", "g"));
        System.out.println(StringUtil.rkFind("abcdefg", ""));
        System.out.println(StringUtil.rkFind("", "a"));
        System.out.println(StringUtil.rkFind("", ""));
        System.out.println(StringUtil.rkFind("c", "c"));
    }
    
    public static int bfFind(String a, String b) {
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n - m + 1; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (a.charAt(i + j) == b.charAt(j)) {
                    c++;
                } else {
                    break;
                }
                if (c == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int rkFind(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n == 0 || m == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - m + 1; i++) {
            int hashCode = 0;
            for (int j = 0; j < m; j++) {
                hashCode = 26 * hashCode + (a.charAt(i + j) - 'a');
            }
            map.put(hashCode, i);
        }

        int hashCode = 0;
        for (int j = 0; j < m; j++) {
            hashCode = 26 * hashCode + (b.charAt(j) - 'a');
        }
        return map.getOrDefault(hashCode, -1);
    }

}

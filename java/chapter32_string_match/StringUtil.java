package chapter32_string_match;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
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

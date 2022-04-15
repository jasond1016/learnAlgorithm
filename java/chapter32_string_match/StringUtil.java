package chapter32_string_match;

public class StringUtil {
    public static int bfFind(String a, String b) {
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n - m + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    break;
                }
                return i;
            }
        }
        return -1;
    }

}

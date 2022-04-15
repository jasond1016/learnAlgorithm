package chapter32_string_match;

public class TestStringUtil {
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

}

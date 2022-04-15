package chapter32_string_match;

public class TestStringUtil {
    public static void main(String[] args) {
        System.out.println(StringUtil.bfFind("1234567", "13"));
        System.out.println(StringUtil.bfFind("1234567", "1234567"));
        System.out.println(StringUtil.bfFind("1234567", "123456"));
        System.out.println(StringUtil.bfFind("1234567", "234567"));
        System.out.println(StringUtil.bfFind("1234567", "345"));
        System.out.println(StringUtil.bfFind("1234567", "7"));
        System.out.println(StringUtil.bfFind("1234567", ""));
        System.out.println(StringUtil.bfFind("", "1"));
        System.out.println(StringUtil.bfFind("", ""));
    }

}

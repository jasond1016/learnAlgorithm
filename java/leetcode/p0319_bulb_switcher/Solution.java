package leetcode.p0319_bulb_switcher;

/**
 * Solution
 *
 * @author Jason
 * @date 2022/09/16 19:23
 **/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.bulbSwitch(3)); // 1
        System.out.println(solution.bulbSwitch(0)); // 0
    }
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}

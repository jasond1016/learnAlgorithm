package leetcode.p0398_random_pick_index;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        Solution2 solution = new Solution2(nums);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(2));
        System.out.println(solution.pick(2));
    }

    private final Random random;
    private final Map<Integer, List<Integer>> map;

    public Solution2(int[] nums) {
        random = new Random();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        if (!map.containsKey(target)) {
            return -1;
        }

        List<Integer> options = map.get(target);
        return options.get(random.nextInt(options.size()));
    }
}

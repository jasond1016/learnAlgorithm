package leetcode.p0300_longest_increasing_subsequence;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        int[] nums = new int[]{1,9,2,4,7,6,5,101,18};
//        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        int[] nums = new int[]{0,1,0,3,2,3};
        int[] nums = new int[]{4, 10, 4, 3, 8, 9};
        System.out.println(solution.lengthOfLIS(nums));
    }

    /**
     * patience game
     * 规则：只能把点数小的牌压到点数大的牌上，如果没有可以放的堆就新开一个堆，如果有多个符合条件的堆，总是放到最左面的堆
     */
    public int lengthOfLIS(int[] nums) {
        // 放牌的堆，top[i]表示第i堆中最小的牌
        int[] top = new int[nums.length];
        // 堆数
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 当前牌
            int poker = nums[i];

            // 二分查找左边界
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (poker > top[mid]) {
                    left = mid + 1;
                } else if (poker < top[mid]) {
                    right = mid;
                } else {
                    right = mid;
                }
            }

            // 如果没有可以放置的堆，则新开堆
            if (left == piles) {
                piles++;
            }
            // 多个满足的情况下，总是放到最左面的堆
            top[left] = poker;
        }
        // 堆总数就是最长递增子序列
        return piles;
    }
}

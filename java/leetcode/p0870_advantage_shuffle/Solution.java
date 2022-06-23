package leetcode.p0870_advantage_shuffle;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{2,7,11,15};
        int[] nums2 = new int[]{1,10,4,11};
        System.out.println(Arrays.toString(solution.advantageCount(nums1, nums2)));

        nums1 = new int[]{12,24,8,32};
        nums2 = new int[]{13,25,32,11};
        System.out.println(Arrays.toString(solution.advantageCount(nums1, nums2)));

    }
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // nums2 降序排列，为了不改变 nums2，利用 PriorityQueue 保留原顺序
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> pair2[1] - pair1[1]);

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, nums2[i]});
        }

        // nums1 升序排列
        Arrays.sort(nums1);
        // nums1 最小的值在左面
        int left = 0;
        // nums1 最大的值在右面
        int right = n - 1;
        int[] res = new int[n];
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int i = pair[0];
            int val = pair[1];
            // 如果 nums1 最大的值大于 nums2 最大的值，就用这个值去比较
            if (nums1[right] > val) {
                res[i] = nums1[right];
                right--;
            } else {
                // 反之，则用 nums1 最小的值去比较
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}

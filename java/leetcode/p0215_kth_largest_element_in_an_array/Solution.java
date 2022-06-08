package leetcode.p0215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}

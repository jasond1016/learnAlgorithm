package leetcode.p0088_merge_sorted_array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end1 = m - 1;
        int end2 = n - 1;
        int finish = m + n - 1;
        while (end1 >= 0 && end2 >= 0) {
            nums1[finish--] = nums1[end1] > nums2[end2] ? nums1[end1--] : nums2[end2--];  
        }

        while (end2 >= 0) {
            nums1[finish--] = nums2[end2--];
        }
    }

}

package leetcode.p0654_maximum_binary_tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode res = solution.constructMaximumBinaryTree(nums);
        System.out.println(res);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int from, int to) {
        if (from >= to) {
            return null;
        }
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = from; i < to; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, from, maxIndex);
        root.right = build(nums, maxIndex + 1, to);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
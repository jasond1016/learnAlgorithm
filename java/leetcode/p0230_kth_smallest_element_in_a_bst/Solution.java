package leetcode.p0230_kth_smallest_element_in_a_bst;

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3,
                new TreeNode(1,
                        null,
                        new TreeNode(2)),
                new TreeNode(4));
        System.out.println(solution.kthSmallest(root, 1));
    }

    private int rank;
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
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
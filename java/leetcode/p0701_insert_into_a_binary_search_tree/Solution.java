package leetcode.p0701_insert_into_a_binary_search_tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7));
        TreeNode res = solution.insertIntoBST(root, 5);
        System.out.println(res);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
           return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
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
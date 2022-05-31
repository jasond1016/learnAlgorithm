package leetcode.p0538_convert_bst_to_greater_tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(2,
                                null,
                                new TreeNode(3))),
                new TreeNode((6),
                        new TreeNode(5),
                        new TreeNode(7,
                                null,
                                new TreeNode(8))));

        TreeNode res = solution.convertBST(root);
        System.out.println(res);
    }

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
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
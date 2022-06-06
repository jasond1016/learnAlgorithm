package leetcode.p0700_search_in_a_binary_search_tree;

import sun.reflect.generics.tree.Tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7));
        TreeNode res = solution.searchBST(root, 2);
        System.out.println(res);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        
        if (val > root.val) {
            return searchBST(root.right, val);
        }
        
        if (val < root.val) {
            return searchBST(root.left, val);
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
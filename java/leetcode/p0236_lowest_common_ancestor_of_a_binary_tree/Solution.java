package leetcode.p0236_lowest_common_ancestor_of_a_binary_tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                        new TreeNode(7),
                        new TreeNode(4)));
        TreeNode q = new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8));
        TreeNode root = new TreeNode(3, p, q);
        TreeNode res = solution.lowestCommonAncestor(root, p, q);
        System.out.println(res);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
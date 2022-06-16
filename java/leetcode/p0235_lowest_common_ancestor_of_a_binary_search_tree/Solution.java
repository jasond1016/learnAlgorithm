package leetcode.p0235_lowest_common_ancestor_of_a_binary_search_tree;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = new TreeNode(2,
                new TreeNode(0),
                new TreeNode(4,
                        new TreeNode(3),
                        new TreeNode(5)));
        TreeNode q = new TreeNode(8,
                new TreeNode(7),
                new TreeNode(9));
        TreeNode root = new TreeNode(6, p, q);
        TreeNode res = solution.lowestCommonAncestor(root, p, q);
        System.out.println(res);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minVal = Math.min(p.val, q.val);
        int maxVal = Math.max(p.val, q.val);
        return find(root, minVal, maxVal);
    }

    private TreeNode find(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return null;
        }

        if (root.val == minVal || root.val == maxVal) {
            return root;
        }
        
        if (minVal > root.val) {
            return find(root.right, minVal, maxVal);
        } else if (maxVal < root.val) {
            return find(root.left, minVal, maxVal);
        }

        return root;
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
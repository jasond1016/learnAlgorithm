package leetcode.p0222_count_complete_tree_nodes;

public class Solution {
    private static class TreeNode {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        null));
        System.out.println(solution.countNodes(root));
    }
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int h1 = 0;
        int h2 = 0;
        while (l != null) {
            l = l.left;
            h1++;
        }

        while (r != null) {
            r = r.right;
            h2++;
        }

        if (h1 == h2) {
            return (int) (Math.pow(2, h1) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}

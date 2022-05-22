package leetcode.p0543_diameter_of_binary_tree;

public class Solution {
    int maxDiameter = 0;
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        System.out.println(solution.diameterOfBinaryTree(root));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depthOf(root.left);
        int right = depthOf(root.right);
        int res = left + right;

        return Math.max(res, Math.max(diameterOfBinaryTree2(root.left), diameterOfBinaryTree2(root.right)));
    }

    private int depthOf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(depthOf(root.left), depthOf(root.right)) + 1;
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
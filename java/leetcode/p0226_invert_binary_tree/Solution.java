package leetcode.p0226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        TreeNode result = solution.invertTreeDFS(root);

        root = new TreeNode(1,
                new TreeNode(2),
                null);
        result = solution.invertTreeDFS(root);
        System.out.println(result);
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }

            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
        }

        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTreeDFS(right);
        root.right = invertTreeDFS(left);

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
package chapter23_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(8),
                                new TreeNode(9)
                        ),
                        new TreeNode(5,
                                new TreeNode(10),
                                new TreeNode(11)
                        )
                ),
                new TreeNode(3, null,
                        new TreeNode(7,
                                new TreeNode(14),
                                new TreeNode(15)
                        )
                )
        );
        System.out.println(levelOrder(root));
        System.out.println(inorderTraversal(root));

    }

    // leetcode 102. Binary Tree Level Order Traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                innerList.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(innerList);
        }
        return result;
    }

    // leetcode 94. Binary Tree Inorder Traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();

        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }

        result.add(root.val);

        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }

        return result;
    }
}

package leetcode.p0112_path_sum;

import java.util.Stack;

public class Solution {
    private boolean found = false;
    private int currSum = 0;
    private int targetSum = 0;
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1))));
        System.out.println(solution.hasPathSumTraverse(root, 22));

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
    
    public boolean hasPathSumTraverse(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        traverse(root);
        return found;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == currSum) {
                found = true;
            }
        }
        traverse(root.left);
        traverse(root.right);
        currSum -= root.val;
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
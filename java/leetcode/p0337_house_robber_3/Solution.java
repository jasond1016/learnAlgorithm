package leetcode.p0337_house_robber_3;

import java.util.HashMap;
import java.util.Map;

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
        TreeNode root = new TreeNode(3,
                new TreeNode(2,
                        null,
                        new TreeNode(3)),
                new TreeNode(3,
                        null,
                        new TreeNode(1)));
        System.out.println(solution.rob(root)); // 7

        root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(5,
                        null,
                        new TreeNode(1)));
        System.out.println(solution.rob(root)); // 9
    }

    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 抢当前家，然后去下下家
        int rob = (root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right)));
        // 不抢当前家，然后去下家
        int noRob = rob(root.left) + rob(root.right);
        int res = Math.max(rob, noRob);
        memo.put(root, res);
        return res;
    }
}

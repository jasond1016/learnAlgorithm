package leetcode.p0889_construct_binary_tree_from_preorder_and_postorder_traversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode res = solution.constructFromPrePost(preorder, postorder);
        System.out.println(res);
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        int leftRootVal = preorder[preStart + 1];
        int leftRootIndexInPostorder = map.getOrDefault(leftRootVal, -1);
        int leftSize = leftRootIndexInPostorder - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, postStart + leftSize, postEnd - 1);
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
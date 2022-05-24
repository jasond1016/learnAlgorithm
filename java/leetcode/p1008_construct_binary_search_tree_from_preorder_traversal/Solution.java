package leetcode.p1008_construct_binary_search_tree_from_preorder_traversal;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = new int[]{8, 5, 1, 7, 10, 12};
        TreeNode res = solution.bstFromPreorder(preorder);
        preorder = new int[]{4, 2};
        res = solution.bstFromPreorder(preorder);
        System.out.println(res);
    }

    public TreeNode bstFromPreorder(int[] preorder) {

        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd) {

        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];

        TreeNode root = new TreeNode(rootVal);

        int index = preStart + 1;
        for (; index < preorder.length; index++) {
            if (preorder[index] > rootVal) {
                break;
            }
        }

        root.left = build(preorder, preStart + 1, index - 1);
        root.right = build(preorder, index, preEnd);
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
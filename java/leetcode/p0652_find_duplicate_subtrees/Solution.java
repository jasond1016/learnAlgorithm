package leetcode.p0652_find_duplicate_subtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        null),
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(4),
                                null),
                        new TreeNode(4)));
        List<TreeNode> res = solution.findDuplicateSubtrees(root);
        System.out.println(res);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        if (map.containsKey(subTree)) {
            Integer count = map.get(subTree);
            if (count == 1) {
                res.add(root);
            }
            map.put(subTree, count + 1);

        } else {
            map.put(subTree, 1);
        }
        return subTree;
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
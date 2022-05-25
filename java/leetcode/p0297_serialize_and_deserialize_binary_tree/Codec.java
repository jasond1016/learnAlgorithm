package leetcode.p0297_serialize_and_deserialize_binary_tree;

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

import java.util.LinkedList;

public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.deleteCharAt(0).toString();
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(",").append("null");
            return;
        }

        sb.append(",").append(root.val);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        String[] dataArray = data.split(",");
        for (String node : dataArray) {
            nodes.addLast(node);
        }
        return build(nodes);
    }

    private TreeNode build(LinkedList<String> nodes) {
        String rootVal = nodes.removeFirst();
        if ("null".equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));

        root.left = build(nodes);
        root.right = build(nodes);

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
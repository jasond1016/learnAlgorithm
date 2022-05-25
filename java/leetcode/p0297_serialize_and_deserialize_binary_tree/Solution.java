package leetcode.p0297_serialize_and_deserialize_binary_tree;

public class Solution {
    public static void main(String[] args) {
        // [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));
        System.out.println(ans);
        ans = deser.deserialize(ser.serialize(null));
        System.out.println(ans);
    }
}

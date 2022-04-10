package chapter24_trees;

public class TestTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(33);
        BinarySearchTree.insert(root, 16);
        BinarySearchTree.insert(root, 50);
        BinarySearchTree.insert(root, 13);
        BinarySearchTree.insert(root, 18);
        BinarySearchTree.insert(root, 34);
        BinarySearchTree.insert(root, 58);
        BinarySearchTree.insert(root, 15);
        BinarySearchTree.insert(root, 17);
        BinarySearchTree.insert(root, 25);
        BinarySearchTree.insert(root, 51);
        BinarySearchTree.insert(root, 66);
        BinarySearchTree.insert(root, 19);
        BinarySearchTree.insert(root, 27);
        BinarySearchTree.insert(root, 55);

        BinarySearchTree.printTree(root);

        BinarySearchTree.printTree(BinarySearchTree.find(root,2));
        BinarySearchTree.printTree(BinarySearchTree.find(root,19));
        BinarySearchTree.delete(root,13);
        BinarySearchTree.delete(root,18);
        BinarySearchTree.delete(root,55);
        BinarySearchTree.printTree(root);
        System.out.println(BinarySearchTree.find(root,13));
        System.out.println(BinarySearchTree.find(root,18));
        System.out.println(BinarySearchTree.find(root,55));

        System.out.println(BinarySearchTree.maxDepth(root));

        System.out.println(BinarySearchTree.maxDepth(null));
        System.out.println(BinarySearchTree.maxDepth(new TreeNode(1)));
    }
}

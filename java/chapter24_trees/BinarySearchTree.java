package chapter24_trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

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

    public static TreeNode find(TreeNode tree, int data) {
        TreeNode p = tree;
        while (p != null) {
            if (data > p.val) {
                p = p.right;
            } else if (data < p.val) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public static void insert(TreeNode tree, int data) {
        if (tree == null) {
            tree = new TreeNode(data);
            return;
        }

        TreeNode p = tree;
        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else if (data < p.val) {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    // leetcode 450. Delete Node in a BST
    public static void delete(TreeNode tree, int data) {
        // p 指向要删除的节点
        TreeNode p = tree;
        // pp 指向 p 的父节点
        TreeNode pp = null;

        while (p != null && data != p.val) {
            pp = p;
            p = data > p.val ? p.right : p.left;
        }
        if (p == null) {
            // 未找到
            return;
        }

        // 要删除的节点有左右两个子节点
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.val = minP.val;
            p = minP;
            pp = minPP;
        }

        // 要删除的节点只有一个子节点或没有子节点
        TreeNode child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        } else {
            child = null;
        }

        // 删除节点
        if (pp == null) {
            // 删除的是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }

    // leetcode 104. Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void printTree(TreeNode p) {
        if (p == null) {
            System.out.println("Empty tree");
            return;
        }
        List<List<Integer>> tree = levelOrder(p);
        for (int i = 0; i < tree.size(); i++) {
            for (int j = 0; j < tree.get(i).size(); j++) {
                System.out.print(" " + tree.get(i).get(j));
            }
            System.out.println();
        }
    }

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
}

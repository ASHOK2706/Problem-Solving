package BinarySearchTree;

import java.util.Scanner;

public class _06_DeleteNodeInBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        traverseTree(root);
        int key = in.nextInt();
        root = deleteNode(root, key);
        traverseTree(root);
    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (root.data == key) {
            return removeRootNode(root);
        }
        TreeNode temp = root;

        while (temp != null) {
            if (temp.data < key) {
                if (temp.right != null && temp.right.data == key) {
                    temp.right = removeRootNode(temp.right);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left != null && temp.left.data == key) {
                    temp.left = removeRootNode(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }
        return root;
    }

    private static TreeNode removeRootNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode rightMostNode = getRightMostNode(root.left);
            rightMostNode.right = rightChild;
            return root.left;
        }
    }

    private static TreeNode getRightMostNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private static void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        traverseTree(root.left);
        traverseTree(root.right);
    }
}

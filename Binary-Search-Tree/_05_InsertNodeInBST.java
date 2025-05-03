package BinarySearchTree;

import java.util.Scanner;

public class _05_InsertNodeInBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.right = new TreeNode(13);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int val = in.nextInt();
        root = insertNode(root, val);
        traverseTree(root);
    }

    private static TreeNode insertNode(TreeNode root, int val) {
        TreeNode current = root;

        while (true) {
            if (current.data < val) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode(val);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }


    private static void traverseTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data+" ");
        traverseTree(root.left);
        traverseTree(root.right);
    }
}

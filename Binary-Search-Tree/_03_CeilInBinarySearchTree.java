package BinarySearchTree;

import java.util.Scanner;

public class _03_CeilInBinarySearchTree {
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

        int key = in.nextInt();
        System.out.println(getCeil(root, key));
    }

    private static int getCeil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data >= key) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }
}

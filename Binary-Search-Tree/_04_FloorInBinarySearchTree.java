package BinarySearchTree;

import java.util.Scanner;

public class _04_FloorInBinarySearchTree {
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
        System.out.println(getFloor(root, key));
    }

    private static int getFloor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data <= key) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return  floor;
    }
}

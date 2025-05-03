package BinarySearchTree;

import java.util.Scanner;

public class _02_FindMinimumInBinarySearchTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        BinarySearchTree tree = new BinarySearchTree();
        for (int i=0; i<n; i++) {
            tree.insert(arr[i]);
        }
        TreeNode root = tree.root;

        System.out.println(getMinimumInBST(root));
    }

    private static int getMinimumInBST(TreeNode root) {
        if (root == null) return -1;
        while (root.left != null) {
            root = root.left;
        }
        return  root.data;
    }
}

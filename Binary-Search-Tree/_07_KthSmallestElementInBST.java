package BinarySearchTree;

import java.util.Scanner;

public class _07_KthSmallestElementInBST {
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
        int k = in.nextInt();
        int[] count = {0};
        int kthSmallest = getKthSmallest(root, k, count);
        System.out.println(kthSmallest);
    }

    private static int getKthSmallest(TreeNode root, int k, int[] count) {
        if (root == null) return -1;
        int left = getKthSmallest(root.left, k, count);
        if (left != -1) return left;
        count[0] = count[0] + 1;
        if (count[0] == k) {
            return  root.data;
        }
        return getKthSmallest(root.right, k, count);
    }
}

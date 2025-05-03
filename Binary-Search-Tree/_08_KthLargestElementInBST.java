package BinarySearchTree;

import java.util.Scanner;

public class _08_KthLargestElementInBST {
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
        int kthLargest = getKthLatgestElement(root, k, count);
        System.out.println(kthLargest);
    }

    private static int getKthLatgestElement(TreeNode root, int k, int[] count) {
        if (root == null) return -1;
        int right = getKthLatgestElement(root.right, k, count);
        if (right != -1)  return right;
        count[0]++;
        if (count[0] == k) return root.data;
        return getKthLatgestElement(root.left, k, count);
    }
}

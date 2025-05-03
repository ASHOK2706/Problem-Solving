package BinarySearchTree;

import java.util.Scanner;

public class _11_ConstructBSTFromPreOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] preorder = new int[n];
        for (int i=0; i<n; i++) {
            preorder[i] = in.nextInt();
        }
        TreeNode root = null;

        for (int val : preorder) {
            root = constructBST(root, val);
        }

        search(root);


    }

    private static TreeNode constructBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (val < root.data) {
            root.left = constructBST(root.left, val);
        } else {
            root.right = constructBST(root.right, val);
        }
        return root;
    }

    private static void search(TreeNode root) {
        if (root == null) return;
        search(root.left);
        System.out.print(root.data+" ");
        search(root.right);
    }
}

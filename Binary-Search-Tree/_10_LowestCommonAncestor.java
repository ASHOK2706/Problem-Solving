package BinarySearchTree;

import java.time.temporal.Temporal;

public class _10_LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode p = root.left;
        TreeNode q = root.right;

        TreeNode lca = getLCA(root, p, q);
        System.out.println(lca.data);
    }
    private static TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int value = root.data;

            if (value < p.data && value < q.data) {
                root = root.right;
            } else if (value > p.data && value > q.data) {
                root = root.left;
            } else {
                return root;
            }
        }
        return root;
    }
}

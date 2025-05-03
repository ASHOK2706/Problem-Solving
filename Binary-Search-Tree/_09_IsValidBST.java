package BinarySearchTree;

public class _09_IsValidBST {
    public static void main(String[] args) {
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

        System.out.println(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    private static boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.data <= minValue || root.data >= maxValue) return false;
        return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, maxValue);
    }
}

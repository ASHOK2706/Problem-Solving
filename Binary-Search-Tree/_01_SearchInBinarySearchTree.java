package BinarySearchTree;
// LeetCode - 700
public class _01_SearchInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(searchBST(root, 2));
    }

    private static boolean searchBST(TreeNode root, int data) {
        while (root != null) {
            if (root.data == data) {
                return true;
            } else if (root.data < data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return  false;
    }
}

package BinarySearchTree;

public class BinarySearchTree {
    TreeNode root;
    public void insert(int data) {
        root = insert(root, data);
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return  new TreeNode(data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}

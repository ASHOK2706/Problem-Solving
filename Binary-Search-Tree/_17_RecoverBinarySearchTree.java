package BinarySearchTree;

public class _17_RecoverBinarySearchTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        printInorder(root);
        recerverBST(root);
        System.out.println();
        printInorder(root);
    }


    private static TreeNode first;
    private static TreeNode last;
    private static TreeNode adjecent;
    private static TreeNode prev;
    private static void recerverBST(TreeNode root) {
        first = last = adjecent = prev = null;
        inorder(root);

        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && adjecent != null) {
            int temp = first.data;
            first.data  = adjecent.data;
            adjecent.data = temp;
        }
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                adjecent = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }


    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data +" ");
        printInorder(root.right);
    }
}

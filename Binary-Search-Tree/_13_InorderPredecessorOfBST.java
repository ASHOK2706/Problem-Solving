package BinarySearchTree;


import java.util.Scanner;

public class _13_InorderPredecessorOfBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(10);
        int key = in.nextInt();
        TreeNode succssor = getInorderSuccessor(root, key);
        TreeNode predecessor = getInorderPredecessor(root, key);
        System.out.println(succssor == null ? "null" : succssor.data);
        System.out.println(predecessor == null ? "null" : predecessor.data);
    }


    private static TreeNode getInorderSuccessor(TreeNode root, int key) {
        TreeNode succssor = null;
        while (root != null) {
            if(root.data > key) {
                succssor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succssor;
    }

    private static TreeNode getInorderPredecessor(TreeNode root, int key) {
        TreeNode predecessor = null;
        while (root != null) {
            if (root.data < key) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }
}

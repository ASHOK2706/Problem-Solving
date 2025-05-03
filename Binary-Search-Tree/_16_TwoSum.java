package BinarySearchTree;


import java.util.Scanner;
import java.util.Stack;

class BSTIterator2 {
    private Stack<TreeNode> stack = new Stack<>();
    private boolean isReverse;
    public BSTIterator2(TreeNode root, boolean isReverse) {
        this.isReverse = isReverse;
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        if (isReverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }
        return node.data;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            this.stack.push(node);
            if (isReverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }
}
public class _16_TwoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(5);
        root.left.right.left.left  = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(11);

        int target = in.nextInt();
        System.out.println(findTarget(root, target));
    }

    private static boolean findTarget(TreeNode root, int target) {
        BSTIterator2 left = new BSTIterator2(root, false);
        BSTIterator2 right = new BSTIterator2(root, true);

        int i = left.next();
        int j = right.next();
        while (i<j) {
            if (i + j == target) return true;
            else if (i + j < target) i = left.next();
            else j = right.next();
        }
        return false;
    }
}

package BinarySearchTree;

import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
public class _14_BinarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        String[] input = {"next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext" };
        BSTIterator obj = new BSTIterator(root);
        for (String s : input) {
            if (s.equals("next")) {
                System.out.println(obj.next());
            } else {
                System.out.println(obj.hasNext());
            }
        }
    }
}

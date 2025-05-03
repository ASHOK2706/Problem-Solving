class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class _12_BalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println((checkBalanced(root) != -1));
    }

    private static int checkBalanced(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = checkBalanced(root.left);
        int rightHeight = checkBalanced(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + max(leftHeight, rightHeight);
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}


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
public class _11_MaximumHeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.right = new Node(6);


        System.out.println(getMaxheight(root));
    }

    private static int getMaxheight(Node root) {
        if(root == null) return 0;
        int left = getMaxheight(root.left);
        int right = getMaxheight(root.right);
        return 1 + max(left, right);
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}

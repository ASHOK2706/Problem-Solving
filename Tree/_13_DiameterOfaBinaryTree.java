class Node {
    int data;
    Node left;
    Node right;

    public Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class _13_DiameterOfaBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.left.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.right.right.right = new Node(9);


        int[] diameter = new int[1];
        getDiameterOfaBinaryTree(root, diameter);
        System.out.println(diameter[0]);
    }


    private static int getDiameterOfaBinaryTree(Node root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getDiameterOfaBinaryTree(root.left, diameter);
        int rightHeight = getDiameterOfaBinaryTree(root.right, diameter);

        diameter[0] = max(diameter[0], leftHeight+ rightHeight);
        return 1 + max(leftHeight, rightHeight);
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}

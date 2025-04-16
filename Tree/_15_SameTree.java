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

public class _15_SameTree {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);


        System.out.println(isSameTree(root1, root2));

    }

    private static boolean isSameTree(Node p, Node q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        if(isSameTree(p.left, p.left) == false) return false;
        if(isSameTree(q.right, q.right) == false) return false;

        return true;
    }
}
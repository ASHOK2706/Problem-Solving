import java.util.Stack;

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
public class _06_IterativeInOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        iterativeInOrderSearch(root);
    }

    private static void iterativeInOrderSearch(Node root) {
        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Node node = root;


        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()) break;

                node = stack.pop();
                System.out.print(node.data +" ");
                node = node.right;
            }
        }
    }
}

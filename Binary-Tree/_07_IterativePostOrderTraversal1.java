import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class _07_IterativePostOrderTraversal1 {
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

        iterativePostOrderSearch(root);

    }

    private static void iterativePostOrderSearch(Node root) {
        if(root == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data+" ");
        }


    }
}

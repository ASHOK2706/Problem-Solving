import java.util.ArrayList;
import java.util.List;
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
class Pair {
    Node node;
    int num;

    public Pair(Node node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class _09_PreInPostOrderTraversals1 {
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

        search(root);
    }

    private static void search(Node root) {
        if(root == null) return;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();


        while(!stack.isEmpty()) {
            Pair it = stack.pop();

            if(it.num == 1) {
                preOrder.add(it.node.data);
                it.num++;
                stack.push(it);

                if(it.node.left != null) {
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.num == 2) {
                inOrder.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.right != null) {
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else {
                postOrder.add(it.node.data);
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);


    }
}

import java.util.ArrayList;
import java.util.List;

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
public class _10_PreInPostOrderTraversal2 {
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



        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        search(root, pre, in, post);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }


    private static void search(Node root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if(root == null) return;

        pre.add(root.data);
        search(root.left, pre, in, post);
        in.add(root.data);
        search(root.right, pre, in, post);
        post.add(root.data);
    }
}

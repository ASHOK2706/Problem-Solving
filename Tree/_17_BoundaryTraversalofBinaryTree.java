import java.util.ArrayList;
import java.util.List;

class Node {
    int  data;
    Node left;
    Node right;

    public Node (int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class _17_BoundaryTraversalofBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        printBoundary(root);
    }
    
    private static void printBoundary(Node root) {

        List<Integer> list = new ArrayList<>();
        if(root == null) System.out.println(list);

        list.add(root.data);

        addLeftBoundary(root, list);
        addLeafs(root, list);
        addRightBoundary(root, list);

        System.out.println(list);
    }

    private static void addLeftBoundary(Node root, List<Integer> list) {
        Node curr = root.left;

        while(curr != null) {
            if(isLeaf(curr) == false) {
                list.add(curr.data);
            }
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private static void addLeafs(Node root, List<Integer> list) {
        if(root == null) {
            return;
        }

        if(isLeaf(root) == true) {
            list.add(root.data);
        }
        addLeafs(root.left, list);
        addLeafs(root.right, list);
    }

    private static void addRightBoundary(Node root, List<Integer> list) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();

        while(curr != null) {
            if(isLeaf(curr) == false) {
                temp.add(curr.data);
            }
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for(int i=temp.size()-1; i>=0; i--) {
            list.add(temp.get(i));
        }

    }

    private static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null) ? true : false;
    }
}

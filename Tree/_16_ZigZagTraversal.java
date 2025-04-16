import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class _16_ZigZagTraversal {
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


        zigZagTraversal(root);

    }

    private static void zigZagTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) System.out.println(result);
        Queue<Node> queue = new LinkedList<>();
        boolean flag = true;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++) {
                Node node = queue.poll();
                //int index = (flag == true) ? i : size-i-1;
                if(flag == true)
                    list.add(node.data);
                else 
                    list.add(0, node.data);

                if(node.left != null)  queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);

            }
            result.add(list);
            flag = !flag;
        }

        System.out.println(result);
    }
}

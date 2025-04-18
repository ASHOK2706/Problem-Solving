import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class _19_TopViewofBinaryTree {
    static class Pair {
        Node node;
        int lineNo;
        public Pair(Node node, int lineNo) {
            this.node = node;
            this.lineNo = lineNo;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node (4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(getTopView(root));
    }

    private static List<Integer> getTopView(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        int minLineNo = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Pair pair = queue.poll();
                if (pair.lineNo < minLineNo) minLineNo = pair.lineNo;
                if (map.containsKey(pair.lineNo)) {
                    map.put(pair.lineNo, pair.node.data);
                }
                else {
                    map.put(pair.lineNo, pair.node.data);
                }

                if (pair.node.left != null) {
                    queue.offer(new Pair(pair.node.left, pair.lineNo-1));
                }
                if (pair.node.right != null) {
                    queue.offer(new Pair(pair.node.right, pair.lineNo+1));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (map.containsKey(minLineNo)) {
            result.add(map.get(minLineNo));
            minLineNo++;
        }
        return result ;
    }
}

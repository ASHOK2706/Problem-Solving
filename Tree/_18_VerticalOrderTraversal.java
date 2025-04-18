import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

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

public class _18_VerticalOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);

        verticalTraversal(root);

    }

    private static void verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        search(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer, List<Integer>> subMap : map.values()) {
            List<Integer> subList = new ArrayList<>();
            for(List<Integer> list : subMap.values()) {
                list.sort(null);
                subList.addAll(list);
            }
            result.add(subList);
        }

        System.out.println(result);
    }

    private static void search(Node root, int vertical, int level, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if(root == null) return;

        if(!map.containsKey(vertical)) {
            map.put(vertical, new TreeMap<Integer, List<Integer>>());
        }
        TreeMap<Integer, List<Integer>> subMap = map.get(vertical);
        if(map.get(vertical).containsKey(level)) {
            List<Integer> list = subMap.get(level);
            list.add(root.data);
            subMap.put(level, list);
            map.put(vertical, subMap);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            subMap.put(level, list);
            map.put(vertical, subMap);
        }

        search(root.left, vertical - 1, level + 1, map);
        search(root.right, vertical + 1, level + 1, map);
    }
}

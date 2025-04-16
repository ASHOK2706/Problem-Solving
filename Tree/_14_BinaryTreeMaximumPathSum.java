
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
public class _14_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node (9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);


        int[] maximunPathSum = {Integer.MIN_VALUE};
        getMaxPathSum(root, maximunPathSum);
        System.out.println(maximunPathSum[0]);
    }

    private static int getMaxPathSum(Node root, int[] maximunPathSum) {
        if (root == null) {
            return 0;
        }

        int leftSum = max(0,getMaxPathSum(root.left, maximunPathSum));
        int rightSum = max(0, getMaxPathSum(root.right, maximunPathSum));

        maximunPathSum[0] = max(maximunPathSum[0], (root.data + leftSum + rightSum));
        
        return root.data + max(leftSum, rightSum);
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}

package BinarySearchTree;


class NodeValue {
    int maxSize;
    int maxNode;
    int minNode;

    public NodeValue(int minNode, int maxNode, int maxSize) {
        this.maxNode = maxNode;
        this.minNode = minNode;
        this.maxSize = maxSize;
    }
}
public class _18_LargestBSTInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.left.left = new TreeNode (14);
        root.left.left.right = new TreeNode(17);
        root.left.right = new TreeNode(18);
        root.left.right.left = new TreeNode(16);
        root.left.right.right = new TreeNode(19);
        root.right = new TreeNode(40);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(60);
        root.right.right.left = new TreeNode(50);

        System.out.println(getLargestBSTFromBT(root));
    }

    private static int getLargestBSTFromBT(TreeNode root) {
        return getLargestBST(root).maxSize;
    }

    private static NodeValue getLargestBST(TreeNode root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = getLargestBST(root.left);
        NodeValue right = getLargestBST(root.right);

        if (left.maxNode < root.data && root.data < right.minNode) {
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode), 1 + left.maxSize + right.maxSize);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}

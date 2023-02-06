package tree;

public class TreeMaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        return calHeight(root);
    }

    public static int calHeight(TreeNode root) { // height = depth
        if (root == null) return 0; // height of a leaf node is 1

        int leftHight = calHeight(root.left);
        int rightHeight = calHeight(root.right);
        return Math.max(leftHight, rightHeight) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            // default constructor
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

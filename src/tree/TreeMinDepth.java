package tree;

public class TreeMinDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        return calHeight(root);
    }

    public static int calHeight(TreeNode root) { // height = depth
        if (root == null) return 0; // height of a leaf node is 1

        int leftHight = calHeight(root.left);
        int rightHeight = calHeight(root.right);
        if (root.left == null && root.right != null) { // avoid get 1
            return 1 + rightHeight;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftHight;
        }
        return Math.min(leftHight, rightHeight) + 1; // only return min when left and right are not null
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

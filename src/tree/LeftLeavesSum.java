package tree;

public class LeftLeavesSum {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int leftSum = sumOfLeftLeaves(root.left); // left
        int rightSum = sumOfLeftLeaves(root.right); // right

        int midSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { // mid, and we know the left leaf
            midSum = root.left.val;
        }
        int res = leftSum + rightSum + midSum;

        return res;
    }

    class TreeNode {
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

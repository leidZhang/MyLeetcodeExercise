package tree;

public class BSTLowestComAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) { // p q in the left subtree
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) return left;
        }
        if (root.val < p.val && root.val < q.val) { // p q in the right subtree
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) return right;
        }

        return root; // p = root.left, q = root.right or p = root.left, q > root.right or p < root.left, q = root.right
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

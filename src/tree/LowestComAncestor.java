package tree;

public class LowestComAncestor {
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) { // p q in the left subtree
            TreeNode left = lowestCommonAncestor(root.left, p, q); // go to left subtree
            if (left != null) return left; // find p or q
        }
        if (root.val < p.val && root.val < q.val) { // p q in the right subtree
            TreeNode right = lowestCommonAncestor(root.right, p, q); // go to right subtree
            if (right != null) return right; // find p or q
        }

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.equals(p) || root.equals(q)) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q); // left
        TreeNode right = lowestCommonAncestor(root.right, p, q); // right
        if (left != null && right != null) { // mid
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else {
            return null;
        }
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

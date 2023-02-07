package tree;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        TreeNode res = null;
        if (val < root.val) res = searchBST(root.left, val);
        if (val > root.val) res = searchBST(root.right, val);
        return res;
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

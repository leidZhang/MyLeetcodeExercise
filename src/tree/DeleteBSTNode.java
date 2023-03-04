package tree;

public class DeleteBSTNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null; // root is null
        if (root.val == key) {
            if (root.left == null && root.right == null) { // root is leaf
                return null;
            } else if (root.left != null && root.right == null) { // root is has left child only
                return root.left;
            } else if (root.left == null && root.right != null) { // root is has right child only
                return root.right;
            } else { // root has left and right child
                TreeNode cur = root.right; // choose right node to replace root
                while (cur.left != null) cur = cur.left;
                cur.left = root.left; // move the left subtree become the left subtree of min successor
                return root.right;
            }
        }

        if (root.val > key) root.left = deleteNode(root.left, key); // val > key, go left
        if (root.val < key) root.right = deleteNode(root.right, key); // val < key, go right

        return root;
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

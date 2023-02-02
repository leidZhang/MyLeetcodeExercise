package tree;

import java.util.ArrayList;
import java.util.List;

public class BinTreePostTrav {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(); // corner case

        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    public static void postorder(List<Integer> res, TreeNode root) { // find left first ?
        if (root == null) return; // stop when get to the leaf node

        if (root.left != null) postorder(res, root.left); // left
        if (root.right != null) postorder(res, root.right); // right
        res.add(root.val); // mid
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

package tree;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {
    static TreeNode pre = null;

    public static boolean isValidBST(TreeNode root) { // two pointers
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean right = isValidBST(root.right);

        return left && right;
    }

    public static boolean isValidBSTBF(TreeNode root) { // brute force
        List<Integer> lst = new ArrayList<>();
        inorder(root, lst);

        for (int i=1; i<lst.size(); i++) {
            int pre = lst.get(i-1);
            int cur = lst.get(i);
            if (pre >= cur) return false;
        }

        return true;
    }

    private static void inorder(TreeNode root, List<Integer> lst) {
        if (root == null) return;

        if (root.left != null) inorder(root.left, lst);
        lst.add(root.val);
        if (root.right != null) inorder(root.right, lst);
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

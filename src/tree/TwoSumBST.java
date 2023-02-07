package tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
    List<Integer> vals = new ArrayList<>();

    public boolean findTargetBF(TreeNode root, int k) {
        inorder(root);
        // System.out.println(vals);

        for (int i=0; i<vals.size(); i++) {
            for (int j=0; j<vals.size(); j++) {
                if (i == j) continue;
                if (vals.get(i) + vals.get(j) == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        if (root.left != null) inorder(root.left);
        vals.add(root.val);
        if (root.right != null) inorder(root.right);
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

package tree;

import java.util.ArrayList;
import java.util.List;

public class BSTMinAbsDiff {
    List<Integer> vals = new ArrayList<>();
    int res = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }

    public int getMinimumDifferenceBF(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<vals.size(); i++) {
            if (i < vals.size() - 1) {
                min = Math.min(min, vals.get(i+1) - vals.get(i));
            }
        }
        return min;
    }

    public void inorder(TreeNode cur) {
        if (cur == null) return;

        if (cur.left != null) inorder(cur.left);
        // vals.add(cur.val);
        if (pre != null) {
            res = Math.min(res, cur.val - pre.val);
        }
        pre = cur;
        if (cur.right != null) inorder(cur.right);
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

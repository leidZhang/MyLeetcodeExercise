package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTreeInTrav {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(); // corner case

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        // inorder(res, root);
        TreeNode cur = root;

        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.peek(); st.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    public static void inorder(List<Integer> res, TreeNode root) { // find left first ?
        if (root == null) return; // stop when get to the leaf node

        if (root.left != null) inorder(res, root.left);
        res.add(root.val);
        if (root.right != null) inorder(res, root.right);
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

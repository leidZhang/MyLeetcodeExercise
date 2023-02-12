package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTreePreTrav {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.left.left.right = new TreeNode(2);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>(); // corner case

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        // preorder(res, root);
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode cur = st.peek();
            st.pop();

            if (cur == null) continue;
            res.add(cur.val); // mid
            st.push(cur.right); // right
            st.push(cur.left); // left
        }

        return res;
    }

    public static void preorder(List<Integer> res, TreeNode root) { // find mid first ?
        if (root == null) return; // stop when get to the leaf node

        res.add(root.val);
        if (root.left != null) preorder(res, root.left);
        if (root.right != null) preorder(res, root.right);
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

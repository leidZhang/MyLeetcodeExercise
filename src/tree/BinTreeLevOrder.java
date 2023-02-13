package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinTreeLevOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder2(root));
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) { // bfs
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            while (size != 0) {
                TreeNode cur = q.poll();
                level.add(cur.val);

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                size--;
            }

            res.add(new ArrayList<>(level));
        }

        return res;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>(); // queue
        TreeNode node = root; q.add(node); // init q

        while (!q.isEmpty()) { // bfs?
            int size = q.size(); // size is the number of nodes in the current level
            List<Integer> cur = new ArrayList<>();

            while (size != 0) { // do not use q.size() here!!!
                TreeNode top = q.peek(); // get the current node
                cur.add(top.val);
                q.poll(); size--; // pop the current node
                if (top.left != null) q.add(top.left); // add left node
                if (top.right != null) q.add(top.right); // add right node
            }
            res.add(new ArrayList<>(cur)); // put the result into res
        }

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

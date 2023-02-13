package tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreTrav {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(Node root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        for (int i=0; i<root.children.size(); i++) {
            Node child = root.children.get(i);
            traversal(child, res);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}

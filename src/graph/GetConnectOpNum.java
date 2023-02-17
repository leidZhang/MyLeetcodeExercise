package graph;

import java.util.Arrays;

public class GetConnectOpNum {
    int[] parent; // disjoint set

    public int makeConnectedDS(int n, int[][] connections) {
        if (connections.length < n-1) return -1;

        int res = 0;
        parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i=0; i<connections.length; i++) {
            int x = connections[i][0];
            int y = connections[i][1];
            union(x, y);
        }
        for (int i=0; i<n; i++) {
            if (parent[i] == -1) res++;
        }

        return res - 1;
    }

    private int findRoot(int x) {
        int xRoot = x;
        while (parent[xRoot] != -1) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    private void union(int x, int y) {
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);

        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}

package graph;

import java.util.Arrays;

public class ExistPaths {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,0}};
        int source = 0,destination = 2, n = 3;
        System.out.println(validPath(n, edges, source, destination));
    }
    static int[] parent; // store the parent, -1 means the parent is itself, i.e. no edge point to other nodes
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        Arrays.fill(parent, -1); // initialize parent

        for (int i=0; i<edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            union(x, y);
        }

        for (int i: parent) { // print parent
            System.out.print(i + " ");
        }
        System.out.print("\n");

        return findRoot(source) == findRoot(destination);
    }

    public static int findRoot(int x) { // find root node
        int xRoot = x;
        while (parent[xRoot] != -1) {
            xRoot = parent[xRoot];
        }
        return xRoot;
    }

    public static void union(int x, int y) { // connect their root node
        int xRoot = findRoot(x);
        int yRoot = findRoot(y);

        if (xRoot != yRoot) {
            parent[xRoot] = yRoot;
        }
    }
}

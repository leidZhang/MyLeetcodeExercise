package graph;

public class StarGraphCenter {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {5,1}, {1,3}, {1,4}};
        System.out.println(findCenter(edges));
    }

    private static int findCenter(int[][] edges) {
        int[] edge1 = edges[0];
        int[] edge2 = edges[1];
        if (edge1[0] == edge2[0] || edge1[0] == edge2[1]) {
            return edge1[0];
        } else {
            return edge1[1];
        }
    }

    public static int findCenterN(int[][] edges) { // normal way
        int[] degrees = new int[edges.length + 1]; // use array to store degree of each node

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            degrees[node1 - 1]++;
            degrees[node2 - 1]++;
        }

        int max = 0; int idx = 0;
        for (int i=0; i<degrees.length; i++) {
            if (max < degrees[i]) {
                max = degrees[i];
                idx = i + 1;
            }
        }

        return idx;
    }
}

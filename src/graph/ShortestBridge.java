package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}};

        System.out.println(shortestBridge(grid));
    }
    /**
     * 1. use dfs find the start points
     * grid[][]:
     * 1 1 1 1 1        2 2 2 2 2
     * 1 0 0 0 1        2 0 0 0 2
     * 1 0 1 0 1   ->   2 0 1 0 2
     * 1 0 0 0 1        2 0 0 0 2
     * 1 1 1 1 1        2 2 2 2 2
     * 2. use bfs to find the shortest route
     * dists[][]:
     * 0 0 0 0 0        0 0 0 0 0
     * 0 0 0 0 0        0 1 1 0 0  <- find 1 in grid[][], so bfs stops here
     * 0 0 0 0 0   ->   0 0 0 0 0
     * 0 0 0 0 0        0 0 0 0 0
     * 0 0 0 0 0        0 0 0 0 0
     * */
    static int n; // rows
    static int m; // cols
    static boolean[][] visited;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dists;

    public static int shortestBridge(int[][] grid) {
        n = grid.length; m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        dists = new int[n][m];

        boolean find = false;
        for (int i=0; i<n && !find; i++) { // dfs find start points
            for (int j=0; j<m && !find; j++) {
                if (grid[i][j] == 1) {
                    find = true;
                    dfs(grid, i, j, q);
                }
            }
        }

        while (!q.isEmpty()) { // bfs find the shortest distance
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;
                for (int k=0; k<4; k++) {
                    int x = cur[0] + dir[k][0];
                    int y = cur[1] + dir[k][1];
                    if (isInRange(x, y) && !visited[x][y] && grid[x][y] == 0) {
                        dists[x][y] = dists[cur[0]][cur[1]] + 1;
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                    if (isInRange(x, y) && grid[x][y] == 1) {
                        return dists[cur[0]][cur[1]];
                    }
                }
                size--;
            }
        }

        return -1;
    }

    private static void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if(!isInRange(i, j) || grid[i][j] == 0) return;
        if (grid[i][j] == 2) return;

        grid[i][j] = 2;
        q.add(new int[]{i, j}); // put into queue when dfs
        for (int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            dfs(grid, x, y, q);
        }
    }

    private static boolean isInRange(int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }

    private static void printMatrix(int[][] grid) { // debug method
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

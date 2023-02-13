package graph;

import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        mat = updateMatrix(mat);

        for (int i=0; i< mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    static int n; // rows
    static int m; // cols
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;

    public static int[][] updateMatrix(int[][] mat) {
        n = mat.length; m = mat[0].length;
        visited = new boolean[n][m];
        int[][] dists = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) { // bfs
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true; // we have visited this grid
                for (int k=0; k<4; k++) {
                    int x = cur[0] + dir[k][0];
                    int y = cur[1] + dir[k][1];
                    if (isInRange(x, y) && !visited[x][y] && mat[x][y] == 1) {
                        dists[x][y] = dists[cur[0]][cur[1]] + 1; // start from grid[cur[0]][cur[1]
                        visited[x][y] = true; // now we have visited this grid
                        q.add(new int[]{x, y});
                    }
                }
                size--;
            }
        }

        return dists;
    }

    private static boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

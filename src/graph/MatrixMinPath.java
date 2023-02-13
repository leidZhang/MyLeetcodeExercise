package graph;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixMinPath {
    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,1,1,0},{1,1,1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    static int n; // rows
    static int m; // cols;
    static boolean[][] visited;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}}; // make sure write the correct direction array

    public static int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length; m = grid[0].length;
        visited = new boolean[n][m];
        int[][] dists = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0}); dists[0][0] = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;
                for (int k=0; k<8; k++) {
                    int x = cur[0] + dir[k][0]; // make sure write the correct value here
                    int y = cur[1] + dir[k][1]; // make sure write the correct value here
                    if (isInRange(x, y) && !visited[x][y] && grid[x][y] == 0) {
                        dists[x][y] = dists[cur[0]][cur[1]] + 1;
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
                size--;
            }
        }

        return dists[n-1][m-1];
    }

    private static boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

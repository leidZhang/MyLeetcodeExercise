package graph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    public static void main(String[] args) {
        char[][] maze = {{'+','+','+'},
                         {'.','.','.'},
                         {'+','+','+'}};
        int[] entrance = {1,0};

        System.out.println(nearestExit(maze, entrance));
    }
    static int n; // rows
    static int m; // cols
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int[][] dists;
    static boolean[][] visited;

    public static int nearestExit(char[][] maze, int[] entrance) {
        n = maze.length; m = maze[0].length;
        visited = new boolean[n][m];
        dists = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance); // we start from entrance

        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                visited[cur[0]][cur[1]] = true;
                for (int k=0; k<4; k++) {
                    int x = cur[0] + dir[k][0];
                    int y = cur[1] + dir[k][1];
                    if (isInRange(x, y) && !visited[x][y] && maze[x][y] == '.') {
                        visited[x][y] = true;
                        dists[x][y] = dists[cur[0]][cur[1]] + 1;
                        if (isExit(x, y)) return dists[x][y]; // get to the exit
                        q.add(new int[]{x,y});
                    }
                }
                size--;
            }
        }

        return -1;
    }

    private static boolean isExit(int i, int j) {
        return i == 0 || i == n-1 || j == 0 || j == m-1;
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

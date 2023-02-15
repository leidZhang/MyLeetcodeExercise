package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    int n; // rows
    int m; // cols
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        n = grid.length; m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) { // bfs
            int size = q.size();           // <- node
            while (size != 0) {
                int[] cur = q.poll();
                grid[cur[0]][cur[1]] = 2;
                for (int k=0; k<4; k++) {
                    int x = cur[0] + dir[k][0];
                    int y = cur[1] + dir[k][1];
                    if (isInRange(x, y) && grid[x][y] == 1) {
                        grid[x][y] = 2;                       // <- sub node
                        q.add(new int[]{x, y});
                    }
                }
                size--;
            }

            if (!q.isEmpty()) cnt++; // exclude last    // <- node
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) return -1; // not rotted?
            }
        }

        return cnt;
    }

    private boolean isInRange(int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }
}

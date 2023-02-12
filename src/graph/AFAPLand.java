package graph;

import java.util.LinkedList;
import java.util.Queue;

public class AFAPLand {
    int n;
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maxDistance(int[][] grid) {
        n = grid.length;
        int res = 0, maxDist = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) { // bfs
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                for (int k=0; k<4; k++) {
                    int x = cur[0] + dir[k][0];
                    int y = cur[1] + dir[k][1];
                    if (isInRange(x, y) && grid[x][y] == 0) {
                        grid[x][y] = grid[cur[0]][cur[1]] + 1;
                        maxDist = Math.max(maxDist, grid[x][y]);
                        q.add(new int[]{x, y});
                    }
                }
                size--;
            }
        }

        return (maxDist != 0) ? maxDist - 1 : -1;
    }

    private boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}

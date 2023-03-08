package graph;

public class NumOfIsland {
    int n; // rows
    int m; // cols
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 0;
        for (int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (isInRange(x, y) && grid[x][y] == '1') {
                dfs(grid, x, y);
            }
        }
    }

    private boolean isInRange(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}

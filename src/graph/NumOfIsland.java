package graph;

public class NumOfIsland {
    int m; // row
    int n; // col
    int cnt = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i>= m || j>=n) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0'; // flood fill lands
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

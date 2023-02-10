package graph;

public class EnclavesNum {
    int n; // row
    int m; // col
    int cnt = 0;
    int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};

    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for (int i=0; i<n; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }
        for (int j=0; j<m; j++) {
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }

        cnt = 0;
        for (int i=1; i<n-1; i++) {
            for (int j=1; j<m-1; j++) {
                dfs(grid, i, j);
            }
        }

        return cnt;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i<0 || i>n-1 || j<0 || j>m-1 || grid[i][j] == 0) return;

        grid[i][j] = 0; cnt++;
        for (int k=0; k<4; k++) {
            dfs(grid, i + direct[k][0], j + direct[k][1]);
        }
    }
}

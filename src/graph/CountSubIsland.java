package graph;

public class CountSubIsland {
    int n; // row
    int m; // col
    int[][] direct = {{1,0},{-1,0},{0,1},{0,-1}};

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid1.length; m = grid1[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i<0 || i>n-1 || j<0 || j>m-1 || grid[i][j] == 0) return;

        grid[i][j] = 0;
        for (int k=0; k<4; k++) {
            dfs(grid, i + direct[k][0], j + direct[k][1]);
        }
    }
}

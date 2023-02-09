package graph;

public class MaxIsland {
    int[][] dircts = {{1,0},{-1,0},{0,1},{0,-1}};
    int cnt = 0;
    int max = 0;
    int n; // rows
    int m; // cols

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dfs(grid, i, j);
                max = Math.max(max, cnt);
                cnt = 0;
            }
        }

        return max;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j] == 0) return;

        grid[i][j] = 0; cnt++;
        for (int k=0; k<4; k++) {
            dfs(grid, i+dircts[k][0], j+dircts[k][1]);
        }
    }
}

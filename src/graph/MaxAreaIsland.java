package graph;

public class MaxAreaIsland {
    int n; // rows
    int m; // cols
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    int cnt = 0;
    int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length; m = grid[0].length;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                dfs(grid, i, j);
                maxArea = Math.max(maxArea, cnt);
                cnt = 0;
            }
        }

        return maxArea;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (!isInRange(i, j) || grid[i][j] == 0) return;

        cnt++;
        grid[i][j] = 0;
        for (int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            dfs(grid, x, y);
        }
    }

    private boolean isInRange(int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }
}

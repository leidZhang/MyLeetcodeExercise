package graph;

public class ClosedIslandNum {
    public static void main(String[] args) {
        int[][] grid = {
                    {1,1,1,1,1,1,1,0},
                    {1,0,0,0,0,1,1,0},
                    {1,0,1,0,1,1,1,0},
                    {1,0,0,0,0,1,0,1},
                    {1,1,1,1,1,1,1,0}
                };

        System.out.println(closedIsland(grid));
    }

    static int n; // rows
    static int m; // cols
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public static int closedIsland(int[][] grid) {
        int cnt = 0;
        n = grid.length; m = grid[0].length;

        for (int i=0; i<n; i++) { // edge grids
            dfs(grid, i, 0);
            dfs(grid, i, m-1);
        }
        for (int j=0; j<m; j++) {
            dfs(grid, 0, j);
            dfs(grid, n-1, j);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }
    /**
     *         ?
     *         |
     * ? -- (0 ->1) -- ?
     *        |
     *        ?
     * */
    public static void dfs(int[][] grid, int i, int j) {
        if (i<0 || i>=n || j<0 || j>=m || grid[i][j] == 1) return;

        grid[i][j] = 1;
        for (int k=0; k<4; k++) {
            dfs(grid, i+directions[k][0], j+directions[k][1]);
        }
    }
}

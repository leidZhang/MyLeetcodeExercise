package graph;

import java.util.ArrayList;
import java.util.List;

public class POATLFlow {
    int n; // rows
    int m; // cols
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] aVisited; // flow from atlantic
    boolean[][] pVisited; // flow from pacific

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length; m = heights[0].length;
        aVisited = new boolean[n][m]; pVisited = new boolean[n][m];
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<m; i++) {
            dfs(heights, 0, i, 1); // 1 pacific
            dfs(heights, n - 1, i, 0); // 0 atlantic
        }
        for (int j=0; j<n; j++) {
            dfs(heights, j, 0, 1); // 1 pacific
            dfs(heights, j, m - 1, 0); // 0 atlantic
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (aVisited[i][j] && pVisited[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int i, int j, int code) {
        if (i < 0 || j < 0 || i > n-1 || j > m-1) return;
        if (code == 0 && aVisited[i][j]) return;
        if (code == 1 && pVisited[i][j]) return;

        if (code == 0) aVisited[i][j] = true;
        if (code == 1) pVisited[i][j] = true;
        for (int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (isInRange(x, y) && heights[i][j] <= heights[x][y]) {
                dfs(heights, x, y, code);
            }
        }
    }

    private boolean isInRange(int i, int j) {
        return i>=0 && i<n && j>=0 && j<m;
    }
}

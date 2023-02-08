package graph;

public class FloodFill {
    boolean[][] visited;
    int initColor;
    int newColor;
    int m; // row
    int n; // col

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        visited = new boolean[m][n];
        initColor = image[sr][sc];
        newColor = color;

        dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int i, int j) { // i row, j col
        if (i < 0 || j < 0 || i >= m || j >= n) return; // cannot exceed boundary
        if (visited[i][j]) return; // cannot visit again

        if (image[i][j] == initColor) {
            image[i][j] = newColor;
        } else {
            return; // no need to fill other grids
        }

        visited[i][j] = true;
        dfs(image, i + 1, j); // left grid
        dfs(image, i - 1, j); // right grid
        dfs(image, i, j + 1); // upper grid
        dfs(image, i, j - 1); // below grid
    }
}

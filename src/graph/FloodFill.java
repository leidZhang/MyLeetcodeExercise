package graph;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                            {0,0,0},
                            {0,0,0},
                            {0,0,0}
                        };
        image = floodFill(image, 1, 0, 2);
        printMatrix(image);
    }
    static int n; // rows
    static int m; // cols
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean[][] visited;
    static int initColor;
    static int newColor;

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length; m = image[0].length;
        visited = new boolean[n][m];
        initColor = image[sr][sc];
        newColor = color;

        dfs(image, sr, sc);

        return image;
    }

    private static void dfs(int[][] image, int i, int j) {
        if (!isInRange(i, j) || visited[i][j]) return;
        if (image[i][j] != initColor) return;

        visited[i][j] = true;
        image[i][j] = newColor;
        for (int k=0; k<4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            dfs(image, x, y);
        }
    }

    private static boolean isInRange(int i, int j) {
        return i>=0 && j>=0 && i<n && j<m;
    }

    private static void printMatrix(int[][] grid) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

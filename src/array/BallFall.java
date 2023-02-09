package array;

import java.util.Arrays;

public class BallFall {
    public static void main(String[] args) {
        int[][] grid = {
                    {-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,1,-1,-1,1,1,-1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,1,1,1,-1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1,1,1,1,-1,-1,-1,-1}
                };
        int[] ll = findBall(grid);

        for (int i : ll) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    static int[] res;

    public static int[] findBall(int[][] grid) {
        res = new int[grid[0].length];
        Arrays.fill(res, -1);

        for (int i=0; i<grid[0].length; i++) {
            dfs(grid, 0, i, i);
        }

        return res;
    }

    public static void dfs(int[][] grid, int rowIndex, int colIndex, int startIndex) {
        // fall or stop? put here in case there is only 1 row
        if (colIndex == 0 && grid[rowIndex][colIndex] == -1) return;
        if (colIndex == grid[0].length - 1 && grid[rowIndex][colIndex] == 1) return;
        if (colIndex + 1 < grid[0].length && grid[rowIndex][colIndex] == 1 && grid[rowIndex][colIndex + 1] == -1) return ;
        if (colIndex > 0 && grid[rowIndex][colIndex] == -1 && grid[rowIndex][colIndex - 1] == 1) return ;
        // reach the largest row
        if (rowIndex == grid.length - 1) {
            if (grid[rowIndex][colIndex] == -1) {
                res[startIndex] = colIndex - 1;
            } else {
                res[startIndex] = colIndex + 1;
            }
            return ;
        }
        // continue falling
        if (grid[rowIndex][colIndex] == 1) colIndex++;
        if (grid[rowIndex][colIndex] == -1) colIndex--;
        dfs(grid, rowIndex + 1, colIndex, startIndex);
    }
}

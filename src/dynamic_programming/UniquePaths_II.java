package dynamic_programming;

public class UniquePaths_II {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1,0}};
        System.out.print(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
        int[][] dp = new int[rowNum][colNum];
        // init dp
        for (int j=0; j<colNum; j++) { // col 0
            if (obstacleGrid[0][j] != 1) dp[0][j] = 1;
            else break; // if blocked here, we cannot get to the rest positions in this column, because we cannot go upward
        }
        for (int i=0; i<rowNum; i++) { // row 0
            if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else break; // if blocked here, we cannot get to the rest positions in this row, because we cannot go leftward
        }
        // cal dp
        for (int i=1; i<rowNum; i++) {
            for (int j=1; j<colNum; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        // print dp
        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<colNum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[rowNum - 1][colNum - 1]; // the objective is go to the grid (rowNum, colNum)
    }
}

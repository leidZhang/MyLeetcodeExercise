package dynamic_programming;

public class UniquePaths_I {
    public static void main(String[] args) {
        int m = 3; int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // init dp
        for (int i=1; i<=m; i++) { // init 1th col
            dp[i][1] = 1;
        }
        for (int i=1; i<=n; i++) { // init 1th row
            dp[1][i] = 1;
        }
        // we can also print dp here to check initialization
        // cal number
        for (int i=2; i<=m; i++) { // rows
            for (int j=2; j<=n; j++) { // cols
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int i=0; i<=m; i++) { // print dp
            for (int j=0; j<=n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[m][n]; // return number of ways
    }
}

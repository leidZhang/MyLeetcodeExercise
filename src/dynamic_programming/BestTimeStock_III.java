package dynamic_programming;

public class BestTimeStock_III {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];

        dp[0][1] = -prices[0]; // first buy
        dp[0][2] = 0; // first sell
        dp[0][3] = -prices[0]; // second buy
        dp[0][4] = 0; // second sell

        for (int i=1; i<n; i++) {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<5; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[n-1][4];
    }
}

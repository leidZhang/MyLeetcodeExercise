package dynamic_programming;

public class BestTimeStockCD {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];

        dp[0][0] = -prices[0]; // buy
        dp[0][1] = 0; // not cooldown
        dp[0][2] = 0; // sell
        dp[0][3] = 0; // cooldown

        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]); // keep or buy before cooldown
            dp[i][0] = Math.max(dp[i][0], dp[i-1][3] - prices[i]); // keep or buy after cooldown

            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]); // keep or after cooldown
            dp[i][2] = dp[i-1][0] + prices[i]; // sell after buy
            dp[i][3] = dp[i-1][2]; // cooldown after buy
        }

        int max = 0;
        max = Math.max(dp[n-1][1], dp[n-1][2]);
        max = Math.max(max, dp[n-1][3]);

        return max;
    }
}

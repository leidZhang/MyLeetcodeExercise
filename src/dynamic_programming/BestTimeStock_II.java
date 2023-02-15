package dynamic_programming;

public class BestTimeStock_II {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0]; // buy at 1st day
        dp[0][1] = 0; // skip at 1st day
        for (int i=1; i<n; i++) { // we can buy or sell multiple times
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]); // skip or buy at ith day
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]); // skip or sell at ith day
        }

        return dp[n-1][1];
    }
}

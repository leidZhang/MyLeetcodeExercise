package dynamic_programming;

public class BestTimeStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = -prices[0]; // buy on 1st day
        dp[0][1] = 0; // skip on 1st day
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]); // buy stock or skip
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]); // sell or skip
        }

        for (int i=0; i<n; i++) { // print dp
            System.out.println(dp[i][0] + " " + dp[i][1]);
        }

        return dp[n-1][1];
    }
}

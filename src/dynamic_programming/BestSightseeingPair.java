package dynamic_programming;

public class BestSightseeingPair {
    public int maxScoreSightseeingPairDP(int[] values) {
        // score = values[i] + i + values[j] - j, and i < j
        int n = values.length;
        int max = 0;

        int[] dp = new int[n];
        dp[0] = values[0] + 0; // int left = values[0] + 0;
        for (int i=1; i<n; i++) {
            max = Math.max(max, dp[i-1] + values[i] - i);
            dp[i] = Math.max(dp[i-1], values[i] + i); // left = Math.max(left, values[i] - i);
        }

        return max;
    }

    public int maxScoreSightseeingPairBF(int[] values) {
        // score = values[i] + i + values[j] - j;
        int n = values.length, max = 0;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                max = Math.max(max, values[i] + i + values[j] - j);
            }
        }

        return max;
    }
}

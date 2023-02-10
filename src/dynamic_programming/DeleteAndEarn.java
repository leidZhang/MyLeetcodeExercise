package dynamic_programming;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] hash = new int[10001];

        for (int i : nums)
            hash[i] += 1;

        int[] dp = new int[10001];
        dp[0] = 0; dp[1] = hash[1];
        for(int i=2; i< 10001; i++){
            dp[i] = Math.max(hash[i] * i + dp[i-2], dp[i-1]);
        }

        return dp[10000];
    }
}

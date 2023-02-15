package dynamic_programming;

public class ProdSubArrMaxLen {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,0,1};
        System.out.println(getMaxLen(nums));
    }

    public static int getMaxLen(int[] nums) {
        if (nums.length == 1 && nums[0] > 0) return 1; // edge cases

        int n = nums.length;
        int[][] dp = new int[n][2];

        if (nums[0] > 0) dp[0][1] = 1;
        if (nums[0] < 0) dp[0][0] = 1;

        int max = 0;
        for (int i=1; i<n; i++) {
            // if nums[i] = 0, the max length of either kinds of subarray at this position is 0
            if (nums[i] > 0) {
                dp[i][1] = dp[i-1][1] + 1; // if nums[i] > 0, then positive subarray will extend
                if (dp[i-1][0] == 0) { // this means that the subarray at i-1 is positive
                    dp[i][0] = 0; // the negative subarray become positive subarray
                } else { // subarray at i-1 is negative
                    dp[i][0] = dp[i-1][0] + 1; // current longest negative subarray extend
                }
            }
            if (nums[i] < 0) {
                dp[i][0] = dp[i-1][1] + 1; // if nums[i] < 0, negative subarray will extend
                if (dp[i-1][0] == 0) { // this means that the subarray at i-1 is positive
                    dp[i][1] = 0; // the positive subarray become negative subarray
                } else { // this means that the subarray at i-1 is negative
                    dp[i][1] = dp[i - 1][0] + 1; // the negative subarray become positive subarray after multiply nums[i]
                }
            }
            max = Math.max(max, dp[i][1]); // we have to find the longest subarray has positive product
        }

        System.out.print("Negative prod subarray max length: ");
        for (int i=0; i<n; i++) {
            System.out.print(dp[i][0] + " ");
        }
        System.out.print("\n");

        System.out.print("Positive prod subarray max length: ");
        for (int i=0; i<n; i++) {
            System.out.print(dp[i][1] + " ");
        }
        System.out.print("\n");

        return max;
    }
}

package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * dp[i] is the max robbed value at i
 * if rob ith house, dp[i] = dp[i-2] + nums[i]
 * else dp[i] = dp[i-1]
 * we choose the larger one
 * */
public class HouseRobber {
    public int rob2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // corner case

        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]); // rob 0th
        dp.add(Math.max(nums[0], nums[1])); // rob 0th or 1st

        for (int i=2; i<nums.length; i++) {
            int trobi = dp.get(i-2) + nums[i];
            int frobi = dp.get(i-1);
            dp.add(Math.max(trobi, frobi));
        }

        return Math.max(dp.get(dp.size() - 1), dp.get(dp.size() - 2));
    }
}

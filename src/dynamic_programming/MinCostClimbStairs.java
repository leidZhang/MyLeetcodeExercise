package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class MinCostClimbStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) { // we have to find the min cost to position cost.length
        List<Integer> dp = new ArrayList<>(); // cost when get to ith stair, dp[i] = dp[i-1] + cost[i-1] or dp[i] = dp[i-2] + cost[i-2]
        dp.add(0); dp.add(0); // dp[0] = 0, dp[1] = 0, since we can either stand at 0 or 1

        for (int i=2; i<=cost.length; i++) {
            int c = Math.min(dp.get(i-1) + cost[i-1], dp.get(i-2) + cost[i-2]); // jump 2 stairs or jump 1 stairs?
            dp.add(c); // dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        }

        for (Integer i : dp) { // print dp
            System.out.print(i + " ");
        }
        System.out.print("\n");

        return dp.get(cost.length);
    }
}

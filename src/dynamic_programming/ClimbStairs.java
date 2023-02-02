package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(climbStairsR(n));
    }

    public static int climbStairs(int n) { // similar to fibonacci sequence
        List<Integer> dp = new ArrayList<>(); // dp[i]: number of ways to climb i steps
        dp.add(1); dp.add(1); // [1, 1]

        for (int i=2; i<=n; i++) {
            dp.add(dp.get(i-2) + dp.get(i-1));
        }

        return dp.get(n);
    }

    public static int climbStairsR(int n) { // recursion will exceed time limit
        if (n == 1 || n == 0) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

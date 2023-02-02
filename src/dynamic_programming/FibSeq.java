package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class FibSeq {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        List<Integer> dp = new ArrayList<>(); // dp[i]: ith fib
        dp.add(0); dp.add(1); // [0, 1]

        for (int i=2; i<=n; i++) {
            dp.add(dp.get(i-2) + dp.get(i-1));
        }

        return dp.get(n);
    }
}

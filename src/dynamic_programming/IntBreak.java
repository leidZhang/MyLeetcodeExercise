package dynamic_programming;

public class IntBreak {
    public static void main(String[] args) {
        int n = 10;
        System.out.print(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 0; dp[2] = 1; // init dp

        for (int i=3; i<=n; i++) { // i is the number we want to break
            for (int j=1; j<i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j)); // i = j + (i - j), break to 2 numbers
                dp[i] = Math.max(dp[i], j * dp[i - j]); // i = j + break(i - j), break to multiple numbers
            }
        }

        for (Integer i : dp) { // print dp
            System.out.print(i + " ");
        }
        System.out.print("\n");

        return dp[n];
    }
}

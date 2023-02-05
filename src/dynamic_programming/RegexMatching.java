package dynamic_programming;

public class RegexMatching {
    public static void main(String[] args) {
        String s = "abbba";
        String p = "ab*a";
        System.out.println("\n" + isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        s = " " + s; p = " " + p;
        dp[0][0] = true;
        // s = "", p = ".*"
        for (int i=0; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (j+1 <= m && p.charAt(j+1) == '*') continue; // skip letter before '*'
                if (p.charAt(j) != '*') {
                    dp[i][j] = i>0 && j>0 && dp[i-1][j-1] && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i));
                } else {
                    dp[i][j] = (j>=2 && dp[i][j-2]) || i>0 && j>0 && dp[i-1][j] && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }

            }
        }

        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[n][m];
    }
}

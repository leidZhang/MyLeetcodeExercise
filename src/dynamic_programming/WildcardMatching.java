package dynamic_programming;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s; p = " " + p;
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // "" and ""

        for (int i=0; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (p.charAt(j) != '*') {
                    dp[i][j] = i>0 && j>0 && dp[i-1][j-1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
                } else {
                    dp[i][j] = (j>0 && dp[i][j-1]) || (i>0 && dp[i-1][j]);
                }
            }
        }

        return dp[n][m];
    }
}

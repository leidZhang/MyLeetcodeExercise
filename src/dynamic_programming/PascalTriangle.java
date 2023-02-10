package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        int[][] dp = new int[n][n];
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<n; i++) {
            dp[0][i] = 1;
        }
        for (int j=0; j<n; j++) {
            dp[j][0] = 1;
        }

        for (int j=1; j<n; j++) {
            for (int i=1; i<n; i++) {
                dp[j][i] = dp[j-1][i] + dp[j][i-1];
            }
        }

        for (int j=0; j<n; j++) {
            List<Integer> row = new ArrayList<>();
            for (int i=0; i<=j; i++) {
                row.add(dp[i][j-i]);
            }
            res.add(new ArrayList<>(row));
        }

        return res;
    }
}

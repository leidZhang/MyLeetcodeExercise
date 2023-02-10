package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_II {
    public static void main(String[] args) {
        System.out.println(getRow(5));
    }

    public static List<Integer> getRow(int rowIndex) {
        int[][] dp = new int[rowIndex+1][rowIndex+1];
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<=rowIndex; i++) {
            dp[0][i] = 1;
        }
        for (int j=0; j<=rowIndex; j++) {
            dp[j][0] = 1;
        }

        for (int j=1; j<=rowIndex; j++) {
            for (int i=1; i<=rowIndex; i++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int i=0; i<=rowIndex; i++) {
            for (int j=0; j<=rowIndex; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        for (int i=rowIndex; i>=0; i--) {
            res.add(dp[i][rowIndex-i]);
        }
        return res;
    }
}

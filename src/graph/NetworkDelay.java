package graph;

import java.util.Arrays;

public class NetworkDelay {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    static int INF = Integer.MAX_VALUE / 2; // will overflow if we use MAX_VALUE

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[][] matrix = initialize(times, n); // initialize adjacent martix
        floyd(matrix, n); // cal delay

        int res = 0;
        for (int i=0; i<n; i++) {
            res = Math.max(res, matrix[k-1][i]); // we start from node k, it is stored at k-1th row
        }
        return res >= INF ? -1 : res;
    }

    public static int[][] initialize(int[][] times, int n) {
        int[][] matrix = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i != j) matrix[i][j] = INF;
            }
        }
        // compose net
        for (int i=0; i<times.length; i++) {
            int startNode = times[i][0];
            int tgtNode = times[i][1];
            int delay = times[i][2];
            matrix[startNode-1][tgtNode-1] = delay;
        }

        return matrix;
    }

    public static void floyd(int[][] matrix, int n) {
        // p: transit, i: start, j: tgt
        for (int p=0; p<n; p++) {
            for (int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][p] + matrix[p][j]);
                }
            }
        }
    }
}

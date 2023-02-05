package array;

public class SpiralMatrix_II {
    public static void main(String[] args) {
        int n = 3;
        int[][] res = generateMatrix(n);

        for (int i=0; i<res.length; i++) {
            for (int j=0; j<res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int offest = 1, cnt = 1;
        int startX = 0, startY = 0;

        while (offest <= n / 2) {
            for (int i=startX; i<n-offest; i++) {
                res[startX][i] = cnt++;
            }
            for (int j=startY; j<n-offest; j++) {
                res[j][n-offest] = cnt++;
            }
            for (int i=n-offest; i>=offest; i--) {
                res[n-offest][i] = cnt++;
            }
            for (int j=n-offest; j>=offest; j--) {
                res[j][startY] = cnt++;
            }
            startX++; startY++; offest++;
        }

        if (n % 2 == 1) {
            res[n/2][n/2] = cnt++;
        }
        return res;
    }
}

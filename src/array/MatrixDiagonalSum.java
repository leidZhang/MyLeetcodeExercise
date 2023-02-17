package array;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int l = 0, r = mat[0].length - 1;

        int sum = 0, i = 0;
        while (l < n && r >= 0) {
            if (l == r) {
                sum += mat[i][l++]; r--;
            } else {
                sum += mat[i][l++] + mat[i][r--];
            }
            i++;
        }

        return sum;
    }
}

package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length; // vertical
        int n = matrix[0].length; // horizontal
        int up = 0, down = m - 1, left = 0, right = n - 1;

        while (true) {
            for (int i=left; i<=right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) break;
            for (int j=up; j<=down; j++) {
                res.add(matrix[j][right]);
            }
            if (--right < left) break;
            for (int i=right; i>=left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) break;
            for (int j=down; j>=up; j--) {
                res.add(matrix[j][left]);
            }
            if (++left > right) break;
        }

        return res;
    }
}

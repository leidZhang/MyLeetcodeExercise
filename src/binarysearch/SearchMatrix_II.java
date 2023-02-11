package binarysearch;

public class SearchMatrix_II {
    /**
     *  1  4  7 11 15
     *  2  5  8 12 19
     *  3  6  9 16 22
     * 10 13 14 17 24
     * 18 21 23 26 30
     * We can start from the lower left corner
     * or start form the upper right corner
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int x = n - 1, y = 0;

        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                return true;
            }
        }

        return false;
    }
}

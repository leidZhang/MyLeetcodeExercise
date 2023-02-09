package binarysearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            int l = 0, r = matrix[i].length - 1; // binary search
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] > target) r--;
                else if (matrix[i][mid] < target) l++;
                else return true;
            }
        }

        return false;
    }
}

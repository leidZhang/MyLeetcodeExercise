package array;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] expected = new int[n];
        // fill expected
        for (int i=0; i<n; i++) {
            expected[i] = heights[i];
        }
        // merge sort
        mergeSort(expected);
        // compare
        int cnt = 0;
        for (int i=0; i<n; i++) {
            if (heights[i] != expected[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    public void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) return; // base case
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        // separate to 2 arrays
        int j = 0;
        for (int i=0; i<n; i++) {
            if (i < mid) left[i] = arr[i];
            else right[j++] = arr[i];
        }
        // merge sort subarrays
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public void merge(int[] left, int[] right, int[] arr) {
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int l = 0, r = 0, i = 0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
            }
        }

        while (l < leftSize) arr[i++] = left[l++];
        while (r < rightSize) arr[i++] = right[r++];
    }
}

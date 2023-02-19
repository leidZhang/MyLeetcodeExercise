package bit_manipulation;

public class SortByBitNum {
    public int[] sortByBits(int[] arr) {
        mergeSort(arr);
        return arr;
    }

    private void mergeSort(int[] arr) {
        int n = arr.length;
        if (n == 1) return ;

        int mid = n / 2, j = 0;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i=0; i<n; i++) {
            if (i<mid) left[i] = arr[i];
            else right[j++] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] arr) {
        int l = 0, r = 0, i = 0;
        while (l < left.length && r < right.length) {
            if (count(left[l]) < count(right[r])) {
                arr[i++] = left[l++];
            } else if (count(left[l]) > count(right[r])) {
                arr[i++] = right[r++];
            } else { // special case, if contains same number of 1, choose the smaller one
                if (left[l] < right[r]) arr[i++] = left[l++];
                else arr[i++] = right[r++];
            }
        }

        while (l < left.length) arr[i++] = left[l++];
        while (r < right.length) arr[i++] = right[r++];
    }

    private int count(int num) {
        int cnt = 0;
        while(num != 0){
            cnt = cnt + 1;
            num = (num & (num - 1));
        }
        return cnt;
    }
}

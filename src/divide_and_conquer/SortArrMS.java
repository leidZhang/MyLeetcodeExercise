package divide_and_conquer;

public class SortArrMS {
    public static void main(String[] args) {
        int[] nums = {-2,3,-5};
        nums = sortArray(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private static int[] sortArray(int[] nums) { // O(nlogn)
        mergeSort(nums);
        return nums;
    }

    private static void mergeSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return; // base case, do not miss this!!!

        int leftSize = len / 2;
        int rightSize = len - leftSize;
        int[] leftArr = new int[leftSize];
        int[] rightArr = new int[rightSize];

        int j = 0; // for right array
        for (int i=0; i<len; i++) {
            if (i < leftSize) leftArr[i] = arr[i];
            else rightArr[j++] = arr[i];
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    private static void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int l = 0, r = 0, i = 0;

        while (l < leftSize && r < rightSize) {
            if (leftArr[l] < rightArr[r]) arr[i++] = leftArr[l++]; // we have to transfer from leftArr to arr
            else arr[i++] = rightArr[r++];
        }
        while (l < leftSize) arr[i++] = leftArr[l++]; // in case some left in the left array
        while (r < rightSize) arr[i++] = rightArr[r++]; // in case some left in the right array
    }
}

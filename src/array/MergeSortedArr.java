package array;

public class MergeSortedArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int[] res = new int[m+n];
        int i = 0, j = 0, k = 0;

        while (i<m && j<n) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while(i<m) res[k++] = nums1[i++];
        while(j<n) res[k++] = nums2[j++];

        for (int p=0; p<m+n; p++) {
            nums1[p] = res[p];
        }
    }
}

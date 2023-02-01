package array;

public class MedianTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;

        int[] merge = new int[size];
        int index1 = 0; // index 1
        int index2 = 0; // index 2
        // assemble merge array
        for (int i=0; i<merge.length; i++) {
            if (index2 >= nums2.length || index1 < nums1.length && nums1[index1] < nums2[index2]) {
                merge[i] = nums1[index1++];
            } else {
                merge[i] = nums2[index2++];
            }
        }
        // find median
        if (merge.length % 2 == 0) {
            int right = size / 2;
            int left = (size - 1) / 2;

            return (merge[right] + merge[left]) / 2.0;
        } else {
            return merge[size / 2];
        }
    }
}

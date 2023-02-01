package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,4};
        int target = 4;
        System.out.println(binarySearch(nums, target));
    }
    public static int binarySearch(int[] nums, int target) { // this is [left, right]
        int left = 0;
        int right = nums.length - 1; // right initially at right end

        while (left <= right) {
            int mid = left + (right - left) / 2; // also (right + left) / 2 if we dont have to care about overflow
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

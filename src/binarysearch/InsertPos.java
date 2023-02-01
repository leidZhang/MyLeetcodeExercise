package binarysearch;

public class InsertPos {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) { // O(logn) time complexity
        if (target > nums[nums.length - 1]) return nums.length;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) { // we are in fact, trying to find the left bound, this is [left, right)
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid + 1; // we can also try to find the target, then we have to return mid
        }

        return left; // return right, if we try to find target using [left, right)
    }
}

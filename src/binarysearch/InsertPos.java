package binarysearch;

public class InsertPos {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) { // O(logn) time complexity, consider binary search
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left; // return right, if we try to find target using [left, right)
    }
}

package binarysearch;

public class SearchRotateArr {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) { // O(logn), consider binary search
        int left = 0;
        int right = nums.length - 1;
        // find pivot point by using binary search
        while (left < right) { // right and left will be the index of pivot
            int mid = (left + right) / 2 + 1;
            if (nums[mid] >= nums[0]) left = mid;
            else right = mid - 1;
        }
        // where is the target?
        if (target >= nums[0]) {
            left = 0;
        } else if (target < nums[0]) {
            left = left + 1;
            right = nums.length - 1;
        }
        // find target by using binary search
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}

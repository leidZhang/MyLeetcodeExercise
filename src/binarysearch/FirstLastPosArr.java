package binarysearch;

public class FirstLastPosArr {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);

        for (int i : res)
            System.out.print(i + " ");
    }

    public static int[] searchRange(int[] nums, int target) { // 2 binary search
        if (nums.length == 0) return new int[]{-1,-1};
        // search res[0]
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];

        while (left < right) { // find the left bound
            int mid = left + (right - left) / 2;
            if (nums[mid] >=target) right = mid;
            else left = mid + 1;
        }
        res[0] = (nums[left] == target) ? left : -1;
        // search res[1]
        left = 0;
        right = nums.length - 1; // remember to reset left and right

        while (left < right) { // find the right bound
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        res[1] = (nums[right] == target) ? right : -1;

        return res;
    }
}

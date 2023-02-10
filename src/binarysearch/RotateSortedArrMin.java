package binarysearch;

public class RotateSortedArrMin {
    /**
     * min <= head || min <= tail
     * we are trying to find pivot
     * */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int tail = nums[r];

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= tail) { // if less than tail, it would be the potential min value
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[r];
    }
}

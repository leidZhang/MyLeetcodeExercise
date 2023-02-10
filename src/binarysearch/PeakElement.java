package binarysearch;

public class PeakElement {
    /**
     * If nums[mid] > nums[mid+1], nums[mid] is a potential max value, let r = mid
     * If nums[mid] < nums[mid+1], nums[mid+1] is a potential max value, let l = mid + 1
     * Finally, r will stop at the max element's position
     * */
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid+1]) r = mid;
            else l = mid + 1;
        }

        return r;
    }
}

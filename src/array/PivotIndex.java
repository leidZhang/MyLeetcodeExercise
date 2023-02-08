package array;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sumRight = 0, sumLeft = 0;
        for (int i=0; i<nums.length; i++) sumRight += nums[i];

        for (int i=0; i<nums.length; i++) {
            sumRight -= nums[i];
            if (sumRight == sumLeft) return i; // for example, pivot idx = 0, sumLeft = 0
            sumLeft += nums[i];
        }

        return -1;
    }

    public static int pivotIndexBF(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int sumLeft = (i != 0) ? sumArr(nums, 0, i-1) : 0;
            int sumRight = (i < nums.length - 1) ? sumArr(nums, i+1, nums.length - 1) : 0;
            if (sumLeft == sumRight) return i;
        }

        return -1;
    }

    public static int sumArr(int[] nums, int l, int r) {
        int sum = 0;
        for (int i=l; i<=r; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

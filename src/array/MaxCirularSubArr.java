package array;

public class MaxCirularSubArr {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(nums));
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curMax = 0, max = Integer.MIN_VALUE;
        int curMin = 0, min = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            curMin = Math.min(curMin + nums[i], nums[i]);
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
            total += nums[i];
        }

        if (max <= 0) return max;
        return Math.max(max, total - min);
    }
}

package array;

public class MaxSubArr {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray2(int[] nums) {
        int curMax = 0, max = Integer.MIN_VALUE;

        for (int i : nums) {
            curMax = Math.max(curMax + i, i);
            max = Math.max(max, curMax);
        }

        return max;
    }
    public static int maxSubArray(int[] nums) {
        int subSum = nums[0], maxSum = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (subSum > 0) {
                subSum += nums[i];
            } else { // if subSum = 0, then this sub array have no contribution
                subSum = nums[i];
            }
            maxSum = Math.max(subSum, maxSum);
        }

        return maxSum;
    }
}

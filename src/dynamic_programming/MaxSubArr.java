package dynamic_programming;

public class MaxSubArr {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
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

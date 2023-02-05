package slidingwindow;

import java.util.Arrays;

public class MinSubarrSum {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = {1,2,3,4,5};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, j = 0, minLen = nums.length; // j slow

        for (int i : nums) sum += i;
        if (sum < target) return 0; // corner case
        sum = 0;

        for (int i=0; i<nums.length; i++) { // fast
            sum += nums[i];
            while (sum >= target) {
                int curLen = i - j + 1;
                minLen = Math.min(minLen, curLen);
                sum -= nums[j++];
            }
        }

        return minLen;
    }
}

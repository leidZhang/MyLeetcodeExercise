package math;

import java.util.Arrays;

public class MissingInt {
    public int missingNumber2(int[] nums) { // others solution, can be used in codility demo test
        Arrays.sort(nums);

        int min = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == min) {
                min++;
            }
        }

        return min;
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int tsum = (0 + n) * (n + 1) / 2; // sum without missing

        int rsum = 0; // real sum
        for (int i=0; i<n; i++) {
            rsum += nums[i];
        }

        return tsum - rsum;
    }
}

package twopointers;

import java.util.Arrays;

public class ThreeSumCloest {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) { // double pointer
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) { // find the target
                    return sum;
                } else if (sum > target) { // move the pointer at both side
                    right--;
                } else {
                    left++;
                }
                // update closest
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
            }
        }
        return ans; // did not find target, return closest
    }
}

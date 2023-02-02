package hashtable;

import java.util.Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {13,7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) { // let nums be the hash table store the correct position
            while (nums[i] <= n && nums[i] >= 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i=0; i<n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1; // scan complete, but did not find a missing positive
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

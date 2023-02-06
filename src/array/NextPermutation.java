package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {2,1,4,3};
        nextPermutation(nums);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k > 0 && nums[k-1] >= nums[k]) k--; // find the number at left of pivot

        if (k <= 0) {
            Arrays.sort(nums); // reverse order
        } else {
            int t = nums.length - 1;
            while (nums[t] <= nums[k-1]) t--; // find the first larger than new pivot from left

            swap(nums, t, k-1); // swap these 2 numbers, number at k-1 is the new pivot
            reverse(nums, k, nums.length - 1); // asc after new pivot
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) { // reverse the desc array
            swap(nums, start, end);
            start++; end--;
        }
    }
}

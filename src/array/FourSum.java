package array;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> res  = new HashSet<>(); // Set<List<Integer>> to avoid duplicate

        for (int i=0; i<nums.length-3; i++) { // 3 ints for j, l, r, respectively
            for (int j=i+1; j<nums.length-2; j++) { // j is at the right of i, so it should start at i+1
                int l = j + 1; // left bound
                int r = nums.length - 1; // right bound

                while (l < r) {
                    // separate to 2 parts to avoid overflow
                    long sum1 = nums[i] + nums[j];
                    long sum2 = nums[l] + nums[r];

                    if (sum1 + sum2 == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                    } else if (sum1 + sum2 > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}

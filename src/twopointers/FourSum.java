package twopointers;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum2(nums, target));
    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) { // faster way
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // skip duplicate nums[i]
            for (int j=i+1; j<nums.length; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue; // skip duplicate nums[j]

                int l = j + 1, r = nums.length - 1;
                while (l < r) { // two pointers
                    long sum1 = nums[i] + nums[j];
                    long sum2 = nums[l] + nums[r];

                    if (sum1 + sum2 > target) { // avoid overflow
                        r--;
                    } else if (sum1 + sum2 < target) { // avoid overflow
                        l++;
                    } else {
                        res.add(Arrays.asList(nums[i],nums[j],nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++; // skip duplicate nums[l]
                        while (l < r && nums[r] == nums[r-1]) r--; // skip duplicate nums[r]
                        l++; r--;
                    }
                }
            }
        }

        return res;
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

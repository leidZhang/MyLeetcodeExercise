package twopointers;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {3,0,-2,-1,1,2};
        System.out.println(threeSum2(nums));
    }

    /**
     * scan sorted array to get the first number, call it cur
     * initial left bound at index(cur) + 1 to avoid duplication
     * initial right bound at the end of the array
     * target = 0 - first number
     * num[left] + num[right] should equal to target
     * */

    public static List<List<Integer>> threeSum2(int[] nums) { // a faster way
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0;i<nums.length-2;i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1, k = nums.length - 1, tgt = -nums[i];
            while(j < k){ // two pointers
                if (nums[j] + nums[k] < tgt) {
                    j++;
                } else if (nums[j] + nums[k] > tgt) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j < k && nums[j] == nums[j+1]) j++; // skip duplicate nums[j]
                    while(j < k && nums[k] == nums[k-1]) k--; // skip duplicate nums[k]
                    j++; k--;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0) { // detect empty array
            return new ArrayList<>();
        }

        Set<List<Integer>> res  = new HashSet<>();
        Arrays.sort(nums); // we can directly sort array

        for(int cur=0; cur<nums.length-2; cur++){
            int left = cur + 1; // let left bound at right of the current position to avoid duplication
            int right = nums.length - 1;
            while(left<right){
                int sum = nums[cur]+nums[left]+nums[right];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[cur],nums[left++],nums[right--])); // array to list, then put in res
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(res);
    }
}

package array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    /**
     * scan sorted array to get the first number, call it cur
     * initial left bound at index(cur) + 1 to avoid duplication
     * initial right bound at the end of the array
     * target = 0 - first number
     * num[left] + num[right] should equal to target
     * */
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
                    System.out.println(nums[cur] + " " + nums[left] + " " + nums[right]);
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

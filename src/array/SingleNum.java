package array;

import java.util.Arrays;

public class SingleNum {
    public int singleNumberBF(int[] nums) {
        Arrays.sort(nums);

        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            cnt++;
            if (i < nums.length - 1 && nums[i] != nums[i+1]) {
                if (cnt == 1) return nums[i];
                cnt = 0;
            }
        }

        return nums[nums.length-1];
    }
}

package array;

import java.util.Arrays;

public class MajElement {
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        int cnt = 0, res = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i] != nums[i-1]) cnt = 0;
            cnt++;
            if (cnt > nums.length/2) {
                res = nums[i]; break;
            }
        }

        return res;
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int j = 0, cnt = 0, n = nums.length;
        for (int i=0; i<n; i++) {
            cnt++;
            if (i < n - 1 && nums[i] != nums[i+1]) {
                if (cnt > n/2) return nums[i];
                cnt = 0; j = i + 1;
            }
        }

        return nums[n-1];
    }
}

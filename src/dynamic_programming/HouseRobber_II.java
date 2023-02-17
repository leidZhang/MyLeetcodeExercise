package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber_II {
    public int rob(int[] nums) { // convert to 2 linear conditions
        if (nums.length == 1) return nums[0]; // corner case
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int[] robHead = new int[n - 1];
        int[] robTail = new int[n - 1];

        for (int i=1; i<n; i++) {
            robTail[i-1] = nums[i];
        }
        for (int i=0; i<n-1; i++) {
            robHead[i] = nums[i];
        }

        int maxHead = robHelper(robHead);
        int maxTail = robHelper(robTail);

        return Math.max(maxHead, maxTail);
    }

    public int robHelper(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]); // rob 0th
        dp.add(Math.max(nums[0], nums[1])); // rob 0th or 1st

        for (int i=2; i<nums.length; i++) {
            int trobi = dp.get(i-2) + nums[i];
            int frobi = dp.get(i-1);
            dp.add(Math.max(trobi, frobi));
        }

        return Math.max(dp.get(dp.size() - 1), dp.get(dp.size() - 2));
    }
}

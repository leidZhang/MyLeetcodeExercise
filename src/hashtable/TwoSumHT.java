package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHT {
    public static void main(String[] args) {
        int[] nums = {3,2,4};

        int[] res = twoSum(nums, 6);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);

            int rest = target - nums[i];
            if (map.containsKey(rest) && i != map.get(rest)) {
                return new int[]{i, map.get(rest)};
            }
        }

        return new int[2];
    }
}

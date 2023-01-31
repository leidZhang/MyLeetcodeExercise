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
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(); // nums[i] as key, i as value

        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }

            int rest = target - nums[i];
            if (map.containsKey(rest) && i != map.get(rest)) {
                res[0] = map.get(rest);
                res[1] = i;
                return res;
            }
        }

        return res;
    }
}

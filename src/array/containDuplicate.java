package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class containDuplicate {
    public boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    public boolean containsDuplicateMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) return true;
        }

        return false;
    }
}

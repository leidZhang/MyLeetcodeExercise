package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // sort nums first
        backtracking(nums, 0);
        return res;
    }

    public static void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path)); // collect data at each tree nodes
        if (startIndex > nums.length) return;

        for (int i=startIndex; i<nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) continue; // for example, in the level has 1 1 2 5 6 7, skip the second 1
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

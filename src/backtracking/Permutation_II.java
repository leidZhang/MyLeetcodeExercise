package backtracking;

import java.util.*;

public class Permutation_II {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permute(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length]; // 1 means used, 0 means not used. boolean[] also works
        backtracking(nums, used);
        return res;
    }

    private static void backtracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i-1] == nums[i] && !used[i-1]) continue; // avoid duplication
            if (used[i]) continue;

            path.add(nums[i]); used[i] = true;
            backtracking(nums, used);
            path.remove(path.size() - 1); used[i] = false;
        }
    }
}

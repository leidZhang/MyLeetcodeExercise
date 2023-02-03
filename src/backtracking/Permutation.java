package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length]; // 1 means used, 0 means not used. boolean[] also works
        backtracking(nums, used);
        return res;
    }

    private static void backtracking(int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (used[i] == 1) continue;

            path.add(nums[i]); used[i] = 1;
            backtracking(nums, used);
            path.remove(path.size() - 1); used[i] = 0;
        }
    }
}

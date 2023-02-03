package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public static void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path)); // collect data at each tree nodes
        if (startIndex > nums.length) return;

        for (int i=startIndex; i<nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

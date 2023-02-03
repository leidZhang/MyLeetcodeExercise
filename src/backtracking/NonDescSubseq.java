package backtracking;

import java.util.*;

public class NonDescSubseq {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        System.out.println(findSubsequences(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public static void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1 && path.size() <= nums.length) res.add(new ArrayList<>(path));
        if (path.size() > nums.length) return;

        Set<Integer> s = new HashSet<>(); // store numbers appeared in this level of tree

        for (int i=startIndex; i<nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) continue; // make sure the newest number is the largest
            if (s.contains(nums[i])) continue; // use set to avoid duplication
            s.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

package backtracking;

import java.util.*;

public class CombSum_I {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return res;
    }

    public static void backtracking(int[] candidates, int target, int startIndex) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i);
                path.remove(path.size() - 1);
            }
        }
    }
}

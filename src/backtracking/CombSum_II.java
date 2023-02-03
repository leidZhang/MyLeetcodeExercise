package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSum_II {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    public static void backtracking(int[] candidates, int target, int startIndex) {
        if (target < 0) return; // sum exceed
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1]) continue; // for example, in 1 1 2 5 6 7, skip the second 1
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombSum_II {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> cur = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    public static void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                if (i > start && candidates[i - 1] == candidates[i]) continue; // avoid duplicate

                cur.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}

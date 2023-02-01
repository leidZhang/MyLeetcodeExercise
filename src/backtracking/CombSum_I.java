package backtracking;

import java.util.*;

public class CombSum_I {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> cur = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, target,0);
        return res;
    }

    public static void backtracking(int[] candidates, int target, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(cur));
        } else if (sum < target){
            for (int i=0; i<candidates.length; i++) {
                if (cur.size() == 0 || cur.get(cur.size() - 1) <= candidates[i]) { // asc to avoid duplication
                    cur.add(candidates[i]);
                    sum += candidates[i];
                    backtracking(candidates, target, sum);
                    sum -= candidates[i];
                    cur.remove(cur.size() - 1);
                }

            }
        }
    }
}

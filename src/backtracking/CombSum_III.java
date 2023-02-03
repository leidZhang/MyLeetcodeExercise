package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombSum_III {
    public static void main(String[] args) {
        int k = 9;
        int n = 45;
        System.out.println(combinationSum3(k, n));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0,1);
        return res;
    }

    public static void backtracking(int target, int k, int sum, int startIndex) { // n, k, i, sum
        if (sum > target) return; // cut
        if (path.size() == k && sum == target) { // k determines depth
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<=9; i++) {
            path.add(i); sum += i;
            backtracking(target, k, sum,i + 1);
            sum -= i; path.remove(path.size() - 1);
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) { // n: numbers, k: path.size()
        backtracking(n, k, 1);
        return res;
    }

    public static void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) { // we get to the leaf node
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n-(k-path.size())+1; i++) { // n -> n-(k-path.size())+1
            path.add(i); // gather data
            backtracking(n, k, i + 1); // i = [startIndex, n]
            path.remove(path.size() - 1);
        }
    }
}

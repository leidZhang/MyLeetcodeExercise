package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenParentheses {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        int n = 0;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        backtracking(0, 0, n, "");
        return res;
    }

    /**
     * Note:
     * in every prefix, left > right
     * in s, left = right
     * */
    public static void backtracking(int left, int right, int n, String s) {
        if (left==n && right==n) { // we need n pairs
            res.add(s);
        } else {
            if (left < n) {
                backtracking(left+1, right, n, s + "("); // we can directly add "(" or ")" here
            }
            if (right < n && right < left) {
                backtracking(left, right+1, n, s + ")");
            }
        }
    }
}

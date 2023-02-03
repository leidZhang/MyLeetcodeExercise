package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PartiPalindrome {
    static List<List<String>> res = new ArrayList<>(); // 2D array
    static List<String> path = new ArrayList<>(); // 1D array

    public static void main(String[] args) {
        String s = "accg";
        System.out.println(partition(s));
    }

    public static List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public static void backtracking(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=startIndex; i<s.length(); i++) {
            String sub = s.substring(startIndex, i + 1); // get substring
            if (!isPalindrome(s, startIndex, i)) continue;

            path.add(sub);
            backtracking(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++; r--;
        }

        return true;
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        String s = "25525511135";
        s = insert(s, 3, '.');
        s = remove(s, ".");
        System.out.println(s);

        System.out.println(restoreIpAddresses(s));

    }

    public static List<String> restoreIpAddresses(String s) {
        backtracking(s, 0,0);
        return res;
    }

    public static void backtracking(String s, int cnt, int startIndex) { // cnt is the number of points
        if (cnt == 3) {
            if (isValid(s, startIndex, s.length())) res.add(s); // check the last 1-3 digits
            return;
        }

        for (int i=startIndex; i<s.length() - 1; i++) {
            if (isValid(s, startIndex, i + 1)) {
                s = insert(s, i + 1 , '.');
                backtracking(s, cnt + 1, i + 2);
                s = remove(s, ".");
            }
        }
    }

    public static String remove(String s, String c) {
         int idx = s.lastIndexOf(c);

         String f = s.substring(0, idx);
         String t = s.substring(idx + 1);

         return f + t;
    }

    public static String insert(String s, int idx, char c) {
        String f = s.substring(0, idx);
        String t = s.substring(idx);
        return f + '.' + t;
    }

    public static boolean isValid(String s, int l, int r) {
        String sub = s.substring(l, r);
        if (sub.length() > 3) return false; // since the valid ip format is xxx.xxx.xxx.xxx
        if (sub.charAt(0) == '0' && sub.length() > 1) return false; // avoid things like 023

        int cur = Integer.parseInt(sub);
        if (cur >= 0 && cur <= 255) return true;
        return false;
    }
}

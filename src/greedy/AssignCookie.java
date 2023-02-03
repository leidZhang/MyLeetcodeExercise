package greedy;

import java.util.Arrays;

public class AssignCookie {
    public static void main(String[] args) {
        int[] g = {10,9,8,7}; // children
        int[] s = {5,6,7,8}; // cookie
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0; // for array g
        int j = 0; // for array s
        int res = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                res++;
                i++;
            }
            j++;
        }

        return res;
    }
}

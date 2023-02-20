package slidingwindow;

import java.util.*;

public class FindAllAnagrams {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>(); // edge cases

        List<Integer> res = new ArrayList<>();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        int n = sArr.length, m = pArr.length;

        int[] hash = new int[26];
        int[] window = new int[26];
        for (int i=0; i<m; i++) {
            hash[pArr[i] - 'a']++; // init hash
        }
        for (int i=0; i<m; i++) {
            window[sArr[i] - 'a']++; // init slide window
        }

        int l = 0; // left bound
        for (int r=m; r<=n; r++) { // right bound
            if (Arrays.equals(hash, window)) res.add(l);
            if (r == n) break;
            window[sArr[r] - 'a']++; // move right bound
            window[sArr[l++] - 'a']--; // move left bound
        }

        return res;
    }
}

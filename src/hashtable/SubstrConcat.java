package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstrConcat {
    // static List<String> combs = new ArrayList<>(); // possible combinations

    public static void main(String[] args) {
        String s = "";
        String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));

    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0) return new ArrayList<>(); // corner case

        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = words.length;
        int w = words[0].length();

        Map<String, Integer> total = new HashMap<>(); // hash table store required number of strings
        for (int i = 0; i < words.length; i++) {
            if (!total.containsKey(words[i])) { // there may have duplicate strings in the words[]
                total.put(words[i], 1);
            } else {
                total.put(words[i], total.get(words[i]) + 1);
            }
        }

        for (int i = 0; i < w; i++) { // 0 ~ (w - 1)
            Map<String, Integer> window = new HashMap<>(); // hash table store number of strings in the window
            int count = 0;

            for (int j = i; j + w <= n ; j += w) { // 0, w, 2w, ...
                if (j - i >= w * m) { // j - i is the length of the window, the maximum allowed length is m * w
                    String headWord = s.substring(j - w * m, j - w * (m-1)); // we have to pop the first word out if the window is too long
                    window.put(headWord, window.get(headWord) - 1); // there may have multiple strings = headword
                    if (total.containsKey(headWord) && window.get(headWord) < total.get(headWord)) count--;
                }

                String tailWord = s.substring(j, j + w); // the next word we want to push into the window
                if (!window.containsKey(tailWord)) {
                    window.put(tailWord, 1);
                } else {
                    window.put(tailWord, window.get(tailWord) + 1);
                }
                if (total.containsKey(tailWord) && window.get(tailWord) <= total.get(tailWord)) count++; // we do not need more than requirement
                if (count == m) res.add(j - (m - 1) * w); // meet the requirement, add into res
            }
        }

        return res;
    }

    /*private static void backtracking(String[] words, int idx, String combine) { // backtracking exercise
        if (idx == words.length) {
            combs.add(combine);
        } else {
            for (int i=0; i<words.length; i++) {
                if (!combine.contains(words[i])) { // avoid duplicate
                    String s = words[i]; combine += s;
                    backtracking(words, idx+1, combine); // idx is the number of elements in combine
                    combine = combine.substring(0, combine.lastIndexOf(s)); // cut the last part
                }
            }
        }
    }*/
}

package hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern2(pattern, s));
    }

    public static boolean wordPattern2(String pattern, String s) {
        String[] seq = s.split(" ");
        if (seq.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();

        char[] pat = pattern.toCharArray();
        for (int i=0; i<pat.length; i++) {
            if (!map.containsKey(pat[i]) && !map.containsValue(seq[i])) {
                map.put(pat[i], seq[i]);
            } else {
                if (!seq[i].equals(map.get(pat[i]))) return false;
            }
        }

        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");

        if (strs.length != pattern.length()) return false; // edge cases

        for (int i=0; i<strs.length; i++) {
            String curStr = strs[i];
            char curCh = pattern.charAt(i);
            if (!map.containsKey(curCh) && !map.containsValue(curStr)) {
                map.put(curCh, curStr);
            } else {
                if (!map.containsValue(curStr)) return false; // cannot find in the hashmap
                String pStr = map.get(curCh);
                if (pStr == null || !pStr.equals(curStr)) return false; // does not exist or wrong pattern
            }
        }

        return true;
    }
}

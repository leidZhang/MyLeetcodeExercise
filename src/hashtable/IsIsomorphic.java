package hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (!map.containsKey(sch) && !map.containsValue(tch)) {
                map.put(sch, tch);
            } else {
                if (map.containsKey(sch)) {
                    char temp = map.get(sch);
                    if (temp != tch) return false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

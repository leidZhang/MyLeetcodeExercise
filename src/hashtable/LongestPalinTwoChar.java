package hashtable;

import java.util.HashMap;
import java.util.Map;

public class LongestPalinTwoChar {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count1 = new HashMap<>(); // ab
        Map<String, Integer> count2 = new HashMap<>(); // ba
        Map<String, Integer> count3 = new HashMap<>(); // xx

        for (int i=0; i<words.length; i++) {
            char ch1 = words[i].charAt(0);
            char ch2 = words[i].charAt(1);
            if (ch1 == ch2) {
                count3.put(words[i], count3.getOrDefault(words[i], 0) + 1); // xx
            } else {
                String key = (ch1 > ch2) ? new String(new char[]{ch2, ch1}) : words[i];
                if (ch1 > ch2) {
                    count2.put(key, count2.getOrDefault(key, 0) + 1);
                } else {
                    count1.put(key, count1.getOrDefault(key, 0) + 1);
                }
            }
        }

        int cnt = 0;
        for (Map.Entry<String, Integer> entry : count1.entrySet()) {
            int a = count1.get(entry.getKey());
            int b = (count2.containsKey(entry.getKey())) ? count2.get(entry.getKey()) : 0; // in case ab is in words, but ba is not
            cnt += Math.min(a, b) * 2 * 2;
        }
        int flag = 0; // has single xx to put at the middle?
        for (Map.Entry<String, Integer> entry : count3.entrySet()) {
            int k = entry.getValue() / 2;
            cnt += k * 2 * 2;
            if (entry.getValue() % 2 == 1) {
                flag = 1;
            }
        }

        return cnt + flag * 2;
    }
}

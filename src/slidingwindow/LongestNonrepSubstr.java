package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestNonrepSubstr {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;

        int j = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);

        for (int i=1; i<s.length(); i++) {
            char chr = s.charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);

            if (map.get(chr) < 2) continue;
            maxLen = Math.max(maxLen, i - j);
            while (map.get(chr) != 1) {
                char chl = s.charAt(j++);
                map.put(chl, map.get(chl) - 1);
            }
        }

        return Math.max(maxLen, s.length() - j);
    }

    /**
     * slide window
     * have to define the left bound and the right bound
     * we have to know the location of the last time it appears
     * so we need an array
     * */
    public static int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        int max = 0;

        for (int i=0; i<128; i++) {
            pos[i] = -1; // init map
        }

        int leftbound = 0;
        for (int rightbound=0; rightbound<s.length(); rightbound++) { // i as right bound
            char cur = s.charAt(rightbound); // the character

            // if the char occur again, update to the next position that it appears in the previous
            leftbound = Math.max(leftbound, pos[cur] + 1);
            max = Math.max(max, rightbound - leftbound + 1); // check the maximum

            pos[cur] = rightbound; // update the last position
        }

        return max;
    }
}

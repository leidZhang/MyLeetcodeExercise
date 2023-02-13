package array;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] schs = s.toCharArray();
        char[] tchs = t.toCharArray();

        Arrays.sort(schs);
        Arrays.sort(tchs);
        s = new String(schs);
        t = new String(tchs);

        return t.equals(s);
    }
}

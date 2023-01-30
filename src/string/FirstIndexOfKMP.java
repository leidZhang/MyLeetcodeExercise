package string;

public class FirstIndexOfKMP {
    public static void main(String[] args) {
        String heystack = "aabaabaaf";
        String needle = "aabaaf";

        System.out.println(strStr(heystack, needle));
    }
    /**
     * i is the pointer on haystack, j is the pointer on needle
     * if a different char is found, j should get back
     * next[j-1] is the length that j should go back, here we use the original next[]
     * (next[j] is the length that j should go back if you changed the original next[])
     * In the example in the main function
     * when i = 5, heystack[5] = b, needle[5] = f, so j should get to position 2, since next[4] = 2
     * since needle[2] = b = heystack[5], j go to the next position
     * Eventually, all chars match, j = needle.length,
     * the first index of needle in haystack is i - (needle.length() - 1)
     * */
    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        next = getNext(next, needle);

        for (int i=0, j=0; i<haystack.length(); i++) {
            while (j>0 && haystack.charAt(i) != needle.charAt(j)) j = next[j-1]; // do not use if!!! get back until the same char is found
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length()) return i - (needle.length() - 1);
        }

        return -1; // didn't match, return -1
    }
    /**
     * next[] stores the lenght of the longest equal prefix and postfix
     * of each substring of target string. In the example in the main function,
     * the target string is "aabaaf"
     * 1. a, no common, 0
     * 2. aa, 1 (a and a)
     * 3. aab, 0
     * 4. aaba, 1 (a and a)
     * 5. aabaa, 2 (aa and aa)
     * 6. aabaaf, 0
     * then next[] = {0,1,0,1,2,0}
     * we can also modify next[], then next[] = {-1,0,1,0,1,2}
     * */
    public static int[] getNext(int[] next, String s) {
        int j = 0; // prefix
        next[0] = 0; // init next[]

        for (int i=1; i<s.length(); i++) {
            while (j>0 && s.charAt(j) != s.charAt(i)) { // do not use if!!! get back until the same char is found
                j = next[j-1]; // back
            }
            if (s.charAt(j) == s.charAt(i)) j++;
            next[i] = j;
        }

        return next;
    }
}

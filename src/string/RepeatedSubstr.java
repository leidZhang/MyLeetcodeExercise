package string;

public class RepeatedSubstr {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        next[0] = 0; int j = 0;

        for (int i=1; i<s.length(); i++) { // next[] in KMP
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j-1];
            }
            if (s.charAt(j) == s.charAt(i)) j++;
            next[i] = j;
        }
        // we can find the longest repeated substring length at next[next.length - 1];
        int subLen = s.length() - next[next.length-1];
        return !(subLen == s.length() || s.length() % subLen != 0); // the string itself is not a substring
    }
}

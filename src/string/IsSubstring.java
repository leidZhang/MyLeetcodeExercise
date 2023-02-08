package string;

public class IsSubstring {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true; // edge cases

        int j = 0; // s pointer
        for (int i=0; i<t.length(); i++) {
            char sch = s.charAt(j);
            char tch = t.charAt(i);
            if (sch == tch) j++;
            if (j == s.length()) return true;
        }

        return j == s.length();
    }
}

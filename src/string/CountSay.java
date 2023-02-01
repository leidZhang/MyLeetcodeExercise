package string;

public class CountSay {
    public static void main(String[] args) {
        int n = 4;
        String s = "1";
        // System.out.println(conversion(s));
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) { // sliding window && recursion
        if (n == 1) return "1";
        int left = 0; int right = 0;
        String s = countAndSay(n - 1), res = "";

        while (right < s.length()) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (right + 1 < s.length() && rightChar == s.charAt(right + 1)) {
                right++;
            } else {
                int len = right - left + 1;
                res += "" + len + leftChar;
                left = right + 1;
                right = left;
            }
        }

        return res;
    }
}

package slidingwindow;

public class CountSaySW {
    public static void main(String[] args) {
        int n = 1;
        String s = "1";
        // System.out.println(conversion(s));
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        String res = "1"; // init res
        for (int i = 1; i < n; i++) {
            res = conversion(res);
        }

        return res;
    }

    public static String conversion(String s) { // sliding window
        String res = "";
        int left = 0;
        int right = 0;

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

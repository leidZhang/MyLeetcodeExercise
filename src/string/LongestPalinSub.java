package string;

public class LongestPalinSub {
    public static void main(String[] args) {
        String s = "ggg";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        String res = "";

        for (int i=0; i<s.length(); i++) {
            // odd case
            int leftIndex = i - 1;
            int rightIndex = i + 1;

            String cur = localMaxPalindrome(leftIndex, rightIndex, s);

            if (res.length() < cur.length()) {
                res = cur;
            }

            // even case
            leftIndex = i;
            rightIndex = i + 1;

            cur = localMaxPalindrome(leftIndex, rightIndex, s);

            if (res.length() < cur.length()) {
                res = cur;
            }
        }
        return res;
    }

    /**
     * the substring of a palindrome is also a palindrome
     * thus, we can expand from the center
     * there are 2 kinds of palindrome, odd and even
     */
    public static String localMaxPalindrome(int leftIndex, int rightIndex, String s) {
        while (leftIndex >= 0 && rightIndex<s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--; // expand left
            rightIndex++; // expand right
        }

        return s.substring(leftIndex + 1, rightIndex);
    }
}

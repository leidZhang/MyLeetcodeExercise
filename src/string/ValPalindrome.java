package string;

public class ValPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String pure = "";
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if ((cur >= 'a' && cur <= 'z') || (cur >= '0' && cur <= '9')) {
                pure += cur;
            }
        }

        int l = 0;
        int r = pure.length() - 1;
        while (l < r) {
            if (pure.charAt(l) != pure.charAt(r)) return false;
            l++; r--;
        }

        return true;
    }
}

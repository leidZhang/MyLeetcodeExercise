package string;

public class RevString {
    public String reverseStr(String s, int k) {
        String res = "";

        int cnt = 0;
        for (int i=0; i<s.length(); i+=k) {
            String cur = (i+k<s.length()) ? s.substring(i, i+k) : s.substring(i);
            res += (cnt % 2 == 0) ? reverse(cur) : cur;
            cnt++;
        }

        return res;
    }

    public String reverse(String s) {
        String res = "";
        for (int i=s.length()-1; i>=0; i--) {
            res += s.charAt(i);
        }
        return res;
    }
}

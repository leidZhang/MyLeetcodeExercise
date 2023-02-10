package string;

public class RevStringWords_III {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        String res = "";

        for (int i=0; i<strs.length; i++) {
            String rev = reverse(strs[i]);
            res = res + rev + " ";
        }

        return res.substring(0, res.length() - 1);
    }

    public String reverse(String str) {
        int l = 0, r = str.length() - 1;
        char[] chs = str.toCharArray();

        while (l < r) {
            char temp = chs[l];
            chs[l] = chs[r];
            chs[r] = temp;
            l++; r--;
        }

        return new String(chs);
    }
}

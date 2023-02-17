package string;

public class MergeStrAlter {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int i = 0, j = 0;

        while (i<word1.length() && j<word2.length()) {
            res = res + word1.charAt(i++) + word2.charAt(j++);
        }
        while (i<word1.length()) res = res + word1.charAt(i++);
        while (j<word2.length()) res = res + word2.charAt(j++);

        return res;
    }
}

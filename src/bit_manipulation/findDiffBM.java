package bit_manipulation;

public class findDiffBM {
    public char findTheDifference(String s, String t) {
        int res = 0;

        for (int i=0; i<s.length(); i++) {
            res = res ^ (s.charAt(i) - 'a');
        }
        for (int i=0; i<t.length(); i++) {
            res = res ^ (t.charAt(i) - 'a');
        }

        return (char)(res + 'a');
    }
}

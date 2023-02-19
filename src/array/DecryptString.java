package array;

public class DecryptString {
    public String freqAlphabets(String s) {
        s += "  "; // sentinel
        char[] seq = s.toCharArray();

        String res = "";
        for (int i=0; i<seq.length; i++) {
            if (seq[i] == ' ') break;
            if (seq[i+2] == '#') {
                String idxs = "" + seq[i] + seq[i+1];
                res += "" + (char)(Integer.parseInt(idxs) + 'a' - 1);
                i += 2;
            } else {
                String idxs = "" + seq[i];
                res += "" + (char)(Integer.parseInt(idxs) + 'a' - 1);
            }
        }

        return res;
    }
}

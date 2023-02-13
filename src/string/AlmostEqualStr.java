package string;

public class AlmostEqualStr {
    public boolean areAlmostEqual(String s1, String s2) {
        int cnt = 0;
        char[] hash = new char[2];

        for (int i=0; i<s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2) {
                if (cnt > 2) return false;
                if (cnt == 0) {
                    hash[0] = ch1;
                    hash[1] = ch2;
                }
                if (cnt == 1 && (ch1 != hash[1] || ch2 != hash[0])) {
                    return false;
                }
                cnt++;
            }
        }

        return cnt == 0 || cnt == 2;
    }
}

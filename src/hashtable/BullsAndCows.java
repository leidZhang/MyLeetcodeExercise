package hashtable;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[][] hash = new int[2][10];

        int cnta = 0;
        for (int i=0; i<s.length; i++) {
            hash[0][s[i] - '0']++;
            hash[1][g[i] - '0']++;

            if (s[i] == g[i]) {
                hash[0][s[i] - '0']--; // exclude As
                hash[1][g[i] - '0']--;
                cnta++;
            }
        }

        int cntb = 0;
        for (int i=0; i<10; i++) { // cal Bs
            cntb += Math.min(hash[0][i], hash[1][i]); // minimum is 0
        }

        return cnta + "A" + cntb + "B";
    }
}

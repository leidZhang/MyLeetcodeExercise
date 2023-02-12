package hashtable;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[][] hash = new int[2][26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hash[0][ch - 'a']++;
            } else {
                hash[1][ch - 'A']++;
            }
        }

        int other = 0, odd = 0;
        for (int i=0; i<2; i++) {
            for (int j=0; j<26; j++) {
                if (hash[i][j] % 2 == 1) {
                    other += hash[i][j] - 1;
                    odd = 1;
                } else {
                    other += hash[i][j];
                }
            }
        }

        return other + odd;
    }
}

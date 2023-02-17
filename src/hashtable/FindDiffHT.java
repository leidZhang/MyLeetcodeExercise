package hashtable;

public class FindDiffHT {
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            hash[ch - 'a']++;
        }
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            hash[ch - 'a']--;
        }

        for (int i=0; i<26; i++) {
            if (hash[i] != 0) {
                return (char)(i + 'a');
            }
        }

        return ' ';
    }
}

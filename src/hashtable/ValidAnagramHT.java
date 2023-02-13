package hashtable;

public class ValidAnagramHT {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] hash = new int[26];

        for (int i=0; i<s.length(); i++) {
            int num1 = s.charAt(i) - 'a';
            int num2 = t.charAt(i) - 'a';
            hash[num1]++;
            hash[num2]--;
        }

        for (int i=0; i<26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

package hashtable;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] hash = new int[26];

        for (int i=0; i<ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            hash[ch - 'a']++;
        }

        for (int i=0; i<magazine.length(); i++) {
            char ch = magazine.charAt(i);
            hash[ch - 'a']--;
        }

        for (int i=0; i<26; i++) {
            if (hash[i] > 0) return false;
        }
        return true;
    }
}

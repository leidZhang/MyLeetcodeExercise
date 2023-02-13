package slidingwindow;

import java.util.Arrays;

public class PermutationInStr {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "dcba";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) { // Based on other's solution
        if (s1.length() > s2.length()) return false; // edge cases

        int[] hash1 = new int[26]; // s1 full window
        int[] hash2 = new int[26]; // s2 slide window

        for (int i=0; i<s1.length(); i++) {
            hash1[s1.charAt(i) - 'a']++;
            hash2[s2.charAt(i) - 'a']++;
        }

        int l = 0;
        for (int r=s1.length(); r<s2.length(); r++) {
            if (Arrays.equals(hash1, hash2)) return true;
            hash2[s2.charAt(r) - 'a']++; // update right
            hash2[s2.charAt(l++) - 'a']--; // update left
        }

        return Arrays.equals(hash1, hash2); // in case match at the end
    }
}

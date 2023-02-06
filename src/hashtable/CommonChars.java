package hashtable;

import java.util.ArrayList;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int[] hash = new int[26];
        // reference hashtable
        for (int i=0; i<words[0].length(); i++) {
            hash[words[0].charAt(i) - 'a']++;
        }
        // compare
        for (int i=1; i<n; i++) {
            int[] hashOther = new int[26];
            for (int j=0; j<words[i].length(); j++) {
                hashOther[words[i].charAt(j) - 'a']++;
            }

            for (int j=0; j<26; j++) {
                hash[j] = Math.min(hash[j], hashOther[j]);
            }
        }
        // add to arraylist
        for (int i=0; i<26; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                res.add(c + "");
                hash[i]--;
            }
        }

        return res;
    }
}

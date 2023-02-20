package slidingwindow;

public class LongestRepeatReplace {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        int max = 0;
        int[] window = new int[26];

        int l = 0; // left bound
        for (int r=0; r<s.length(); r++) { // right bound
            window[s.charAt(r) - 'A']++; // add new element to slide window
            if (!isLegalOperation(k, window)) { // illegal status
                char chl = s.charAt(l++); // move left bound
                window[chl - 'A']--; // delete old left most char
            } else {
                max = Math.max(max, r - l + 1); // legal status, update max length
            }
        }

        return max;
    }

    private static boolean isLegalOperation(int k, int[] window) {
        int total = 0, maxFeq = 0;

        for (int i=0; i<26; i++) {
            total += window[i];
            maxFeq = Math.max(maxFeq, window[i]);
        }

        return total - maxFeq <= k;
    }
}

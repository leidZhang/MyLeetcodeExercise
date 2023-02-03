package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterComb {
    static List<String> res = new ArrayList<>();
    static String path = "";
    static String[] letter_decoder = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;

        backtracking(digits, 0);

        return res;
    }

    private static void backtracking(String digits, int idx) { // source , counter, results
        if (idx == digits.length()) {
            res.add(path);
            return;
        }

        int dig = digits.charAt(idx) - '0'; // get dig
        String letters = letter_decoder[dig]; // scan letter_decoder[dig]

        for (int i=0; i<letters.length(); i++) {
            path += letters.charAt(i);
            backtracking(digits, idx + 1);
            path = path.substring(0, path.length() - 1);
        }
    }
}

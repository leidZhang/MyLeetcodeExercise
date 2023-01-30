package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterComb {
    static List<String> res = new ArrayList<>();
    static String[] strs = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        String digits = "2";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }

        backtracking(digits, 0,"");

        return res;
    }

    private static void backtracking(String digits, int idx, String combine) { // source , counter, results
        if (idx == digits.length()) {
            res.add(combine); // combine as container
        } else {
            String s = strs[digits.charAt(idx) - '0']; // get string set

            for (int i=0; i<s.length(); i++) {
                combine += s.charAt(i); // pass a node, add element, eventually get to leaf
                backtracking(digits, idx+1, combine);
                combine = combine.substring(0, combine.length() - 1); // delete the last char, that is back to the last node
            }
        }
    }
}

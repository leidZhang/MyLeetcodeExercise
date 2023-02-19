package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        char[] arr = s.toCharArray();
        backtracking(arr, 0);
        return res;
    }

    private void backtracking(char[] arr, int idx) {
        if (idx >= arr.length) {
            res.add(new String(arr));
            return;
        }

        char ch = arr[idx];
        if (Character.isLetter(ch)) { // like binary tree
            arr[idx] = Character.toUpperCase(ch); // A1b2
            backtracking(arr, idx + 1);
            arr[idx] = Character.toLowerCase(ch); // a1b2
            backtracking(arr, idx + 1);
        } else {
            backtracking(arr, idx + 1);
        }
    }

    public List<String> letterCasePermutation2(String s) {
        int n = s.length();
        LinkedList<String> res = new LinkedList<>();
        res.add(s);

        for (int i=0; i<n; i++) {
            int size = res.size();
            char ch = s.charAt(i);
            if (!Character.isLetter(ch)) continue;
            while (size != 0) { // like binary tree level order traversal
                String cur = res.poll();
                String left = cur.substring(0, i);
                String right = cur.substring(i + 1);
                res.add(left + Character.toUpperCase(ch) + right);
                res.add(left + Character.toLowerCase(ch) + right);
                size--;
            }
        }

        return res;
    }
}

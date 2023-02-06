package stack_and_queue;

import java.util.*;

public class RmKDigits {
    public static void main(String[] args) {
        String num = "1022";
        int k = 2;
        System.out.println(removeKdigits(num, k));
    }

    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer e1, Integer e2) { // here asc
            return e1 - e2; // e2 - e1 for desc
        }
    };

    /**
     * Slow but accepted
     * */
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        int allowNum = num.length() - k;
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<num.length(); i++) {
            int cur = num.charAt(i) - '0';
            while (k > 0 && !st.isEmpty() && cur < st.peek()) { // make sure asc in the queue
                st.pop();
                k--;
            }
            st.add(cur);
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }
        if (res.length() > allowNum) res = res.substring(0, allowNum); // corner case like num = 112, k = 1
        res = removeZero(res); // corner case like num = 10200, k = 1
        return res.equals("") ? "0" : res;
    }

    public static String removeZero(String res) {
        int cnt = 0;
        for (int i=0; i<res.length(); i++) {
            if (res.charAt(i) != '0') break;
            cnt++; // count illegal 0s
        }
        res = res.substring(cnt); // cut string
        return res;
    }
}

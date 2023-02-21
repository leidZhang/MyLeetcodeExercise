package stack_and_queue;

import java.util.Stack;

public class BackspaceStrCmp {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sst = convert(s);
        Stack<Character> tst = convert(t);
        return sst.equals(tst);
    }

    private Stack<Character> convert(String s) {
        char[] sc = s.toCharArray();

        Stack<Character> st = new Stack<>();
        for (int i=0; i<sc.length; i++) {
            if (sc[i] != '#') {
                st.push(sc[i]);
            }
            if (!st.isEmpty() && sc[i] == '#') {
                st.pop();
            }
        }

        return st;
    }
}

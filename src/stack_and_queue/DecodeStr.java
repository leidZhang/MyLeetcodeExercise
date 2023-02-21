package stack_and_queue;

import java.util.Stack;

public class DecodeStr {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<String> preSt = new Stack<>();
        Stack<Integer> timeSt = new Stack<>();

        String res = "";
        int time = 0;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                time = time * 10 + (ch - '0');
            } else if (ch == '[') {
                timeSt.push(time);
                preSt.push(res);
                time = 0;
                res = "";
            } else if (ch == ']') {
                int curTime = timeSt.pop();
                String preStr = preSt.pop();
                while (curTime != 0) {
                    preStr += res;
                    curTime--;
                }
                res = preStr;
            } else {
                res += "" + ch;
            }
        }

        return res;
    }
}

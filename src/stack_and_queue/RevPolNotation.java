package stack_and_queue;

import java.util.Stack;

public class RevPolNotation {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<tokens.length; i++) {
            String s = tokens[i];

            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                st.push(Integer.parseInt(s));
            } else {
                int num1 = st.pop();
                int num2 = st.pop();

                if (s.equals("+")) {
                    st.push(num1 + num2);
                } else if (s.equals("-")) {
                    st.push(num2 - num1);
                } else if (s.equals("*")) {
                    st.push(num1 * num2);
                } else {
                    st.push(num2 / num1);
                }
            }
        }

        return st.pop();
    }
}

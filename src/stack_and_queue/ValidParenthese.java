package stack_and_queue;

import java.util.Stack;

public class ValidParenthese {
    public static void main(String[] args) {
        String s = "{[({)]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> buffer = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if (cur == '{' || cur == '[' || cur == '(') {
                buffer.push(cur);
                continue;
            }

            if (!buffer.isEmpty() && parentheseMatch(buffer.peek(), cur)) {
                buffer.pop();
            } else {
                return false;
            }
        }

        if (buffer.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean parentheseMatch(char peek, char cur) {
        if (peek == '{' && cur == '}') return true;
        if (peek == '[' && cur == ']') return true;
        if (peek == '(' && cur == ')') return true;
        return false;
    }
}

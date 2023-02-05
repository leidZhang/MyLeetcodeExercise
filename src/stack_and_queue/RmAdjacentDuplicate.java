package stack_and_queue;

import java.util.Stack;

public class RmAdjacentDuplicate {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Stack<Character> buffer = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if (buffer.isEmpty()) {
                buffer.add(cur);
                continue;
            }

            if (buffer.peek() == cur) {
                buffer.pop();
            } else {
                buffer.add(cur);
            }
        }

        String res = "";
        while (!buffer.isEmpty()) {
            res = buffer.pop() + res;
        }
        return res;
    }
}

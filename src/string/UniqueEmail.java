package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmail {
    public static void main(String[] args) {
        String[] emails = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (int i=0; i<emails.length; i++) {
            String cur = emails[i];
            unique.add(process(cur));
        }

        return unique.size();
    }

    private static String process(String s) {
        String res = "";
        boolean flagDot = true, flagPlus = false;

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (flagPlus && cur != '@') continue;
            if (flagDot && cur == '.') continue;
            if (cur == '@') {
                flagDot = false;
                flagPlus = false;
            }
            if (cur == '+') {
                flagPlus = true;
                continue;
            }
            res += cur;
        }

        return res;
    }
}

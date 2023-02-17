package string;

public class GoalParser {
    public String interpret(String command) {
        String res = "";

        for (int i=0; i<command.length(); i++) {
            if (command.charAt(i) == ')') continue;
            if (i+1 < command.length() && command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                res = res + "o";
                continue;
            }
            if (command.charAt(i) == '(') i++;
            res = res + command.charAt(i);
        }

        return res;
    }
}

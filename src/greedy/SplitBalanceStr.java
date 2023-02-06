package greedy;

public class SplitBalanceStr {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int cnt = 0, diff = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'L') diff += 1;
            else diff -= 1;
            if (diff == 0) cnt++;
        }

        return cnt;
    }
}

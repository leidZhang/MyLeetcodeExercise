package string;

public class StringToInt {
    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String s) {
        int res = 0;
        int count = 0;
        // delete spaces
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            } else {
                break;
            }
        }
        s = s.substring(count);

        if (s.length() == 0) {
            return 0;
        }
        // get sign
        int sign = 1;

        if (s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        } else if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        // get digs
        boolean flag = false;

        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') {
                int dig = cur - '0';

                if (res > (Integer.MAX_VALUE / 10) || (res == (Integer.MAX_VALUE / 10) && dig > 7)){
                    return (res < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE; // overflow positive?
                }
                if (res < (Integer.MIN_VALUE / 10) || (res == (Integer.MIN_VALUE / 10) && dig > 8)){
                    return (res > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE; // overflow negative?
                }

                res = (res * 10) + dig * sign;

                flag = true; // will return result
            } else if (flag && (cur > '9' || cur < '0')) { // reach other char, return result
                return res;
            } else if (!flag) { // no number, return 0
                return 0;
            }
        }

        return res;
    }
}

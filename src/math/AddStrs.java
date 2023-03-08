package math;

public class AddStrs {
    public String addStrings(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int len = Math.max(n, m);

        int[] table = new int[len + 1];
        int i = n - 1, j = m - 1, k = len;
        while (i >= 0 && j >= 0) {
            table[k--] = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0');
        }

        while (i >= 0) table[k--] = (num1.charAt(i--) - '0');
        while (j >= 0) table[k--] = (num2.charAt(j--) - '0');

        int carry = 0;
        char[] res = new char[len + 1];
        for (k = len; k >= 0; k--) {
            int dig = (table[k] + carry) % 10;
            res[k] = (char)(dig + '0');
            carry = (table[k] + carry) / 10;
        }

        return (res[0] != '0') ? new String(res) : (new String(res)).substring(1);
    }
}

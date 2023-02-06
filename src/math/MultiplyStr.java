package math;

public class MultiplyStr {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        int[] res = new int[n+m];
        // multiplication
        for (int i=n-1; i>=0; i--) { // num1
            for (int j=m-1; j>=0; j--) { // num2
                int cur1 = num1.charAt(i) - '0';
                int cur2 = num2.charAt(j) - '0';
                res[i+j+1] += cur1 * cur2;
            }
        }
        // digit sums
        for (int i=n+m-1; i>=0; i--) {
            int carry = res[i] / 10;
            if (i>0) res[i-1] += carry;
            res[i] = res[i] % 10;
        }
        // put into string
        String ans = "";
        for (int i=0; i<n+m; i++) {
            if (res[i] == 0 && ans.equals("")) continue;
            ans += res[i];
        }

        return ans.equals("") ? "0" : ans; // corner case
    }
}

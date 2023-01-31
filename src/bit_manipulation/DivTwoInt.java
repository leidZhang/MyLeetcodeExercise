package bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class DivTwoInt {
    public static void main(String[] args) {
        int dividend = 39;
        int divisor = 5;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean sign = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = !sign;
        if (dividend > 0) dividend = - dividend;
        if (divisor > 0) divisor = - divisor;

        List<int[]> exp = new ArrayList<>();
        for (int i=divisor, j=-1; i>=dividend; i=i<<1, j=j<<1) { // j+=j is equivalent to a bit operation
            int[] pair = new int[]{i, j};
            exp.add(pair);
            if (i < Integer.MIN_VALUE >> 1) break;
        }

        int res = 0;
        for (int i=exp.size()-1; i>=0; i--) {
            if (exp.get(i)[0] >= dividend) {
                res += exp.get(i)[1];
                dividend -= exp.get(i)[0];
            }
        }

        if (sign) return res;
        return -res;
    }
}

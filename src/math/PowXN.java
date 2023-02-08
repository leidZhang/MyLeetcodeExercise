package math;

public class PowXN {
    public double myPow(double x, int n) {
        long m = n;
        if (n < 0) m = -m;
        double res = 1.0;

        while(m != 0) {
            if ((m & 1) == 1) res *= x;
            x *= x;
            m = m >> 1;
        }

        return n<0 ? 1/res : res;
    }
}

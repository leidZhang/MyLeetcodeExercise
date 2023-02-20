package bit_manipulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        int temp = n, m = 1;
        while (temp != 1) {
            temp = temp >> 1;
            m = m << 1;
        }

        return m == n;
    }
}

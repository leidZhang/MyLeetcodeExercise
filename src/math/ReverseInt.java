package math;

public class ReverseInt {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
        int res = 0;

        while (x != 0) {
            if (x > 0 && res > (Integer.MAX_VALUE - x % 10) / 10) return 0; // (2^31 - 1 - dig) / 10 is the res before overflow
            if (x < 0 && res < (Integer.MIN_VALUE - x % 10) / 10) return 0;

            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
}

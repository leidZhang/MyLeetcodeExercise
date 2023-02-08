package math;

public class isHappyNum {
    public boolean isHappy(int n) {
        while (true) {
            if (n == 1) return true;
            if (n == 2 || n == 4) break;

            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
        }

        return false;
    }
}

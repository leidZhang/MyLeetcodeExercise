package math;

public class NimGame {
    public static void main(String[] args) {
        int n = 30;
        System.out.println(canWinNim(n));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

package math;

public class PalindromeNum {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        // negative?
        if (x < 0) {
            return false;
        }
        // reverse number
        int temp = x;
        int reverse = 0;

        while(temp != 0) {
            reverse = 10 * reverse + temp % 10;
            temp /= 10;
        }

        if (reverse == x) {
            return true;
        }
        return false;
    }
}

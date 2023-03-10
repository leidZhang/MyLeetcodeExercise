package math;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4,8,9};
        int[] res = plusOne(digits);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        digits[n-1] += 1;

        for (int i=n-1; i>=0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] == 10) {
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] res = new int[n+1];
            res[0] = 1;
            for (int i=1; i<n+1; i++)
                res[i] = digits[i-1];
            return res;
        }

        return digits;
    }

    public static int[] plusOne2(int[] digits) {
        int idx = digits.length - 1;
        digits[idx] += 1;

        while (digits[idx] >= 10 && idx >= 1) {
            digits[idx] -= 10;
            digits[--idx] += 1;
        }

        if (digits[idx] == 10) { // tackle "overflow"
            digits[idx] -= 10;

            int[] newDigits = new int[digits.length + 1];
            for (int i=1; i<newDigits.length; i++) {
                newDigits[i] = digits[i-1];
            }
            newDigits[0] = 1;

            return newDigits;
        }

        return digits;
    }
}

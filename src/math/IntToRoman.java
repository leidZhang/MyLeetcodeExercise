package math;

public class IntToRoman {
    public static void main(String[] args) {
        int num = 54;
        System.out.println(intToRoman(num)); 
    }
    /**
     * I - 1
     * V - 5
     * X - 10
     * L - 50
     * C - 100
     * D - 500
     * M - 1000
     * */
    private static String intToRoman(int num) {
        String res = "";

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int counter = 1;
        while (num != 0) {
            int dig = num % 10;
            num /= 10;

            switch (counter) {
                case 1: res = ones[dig] + res; break;
                case 2: res = tens[dig] + res; break;
                case 3: res = hundreds[dig] + res; break;
                case 4: res = thousands[dig] + res; break;
                default: res += ""; break;
            }
            counter++;
        }

        return res;
    }

    // brute force, simple logic
    private static String intToRomanBF(int num) {
        String res = "";
        int temp = num;

        while (num != 0) {
            if (num >= 1000) {
                res += "M";
                num -= 1000;
            } else if (num >= 900) {
                res += "CM";
                num -= 900;
            } else if (num >= 500) {
                res += "D";
                num -= 500;
            } else if (num >= 400) {
                res += "CD";
                num -= 400;
            } else if (num >= 100) {
                res += "C";
                num -= 100;
            } else if (num >= 90) {
                res += "XC";
                num -= 90;
            } else if (num >= 50) {
                res += "L";
                num -= 50;
            } else if (num >= 40) {
                res += "XL";
                num -= 40;
            } else if (num >= 10) {
                res += "X";
                num -= 10;
            } else if (num >= 9) {
                res += "IX";
                num -= 9;
            } else if (num >= 5) {
                res += "V";
                num -= 5;
            } else if (num >= 4) {
                res += "IV";
                num -= 4;
            } else {
                res += "I";
                num -= 1;
            }
        }

        return res;
    }
}

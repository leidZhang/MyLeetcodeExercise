package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        // char[] dict = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i=0; i<s.length(); i++) {
            char curChar = s.charAt(i);
            int curNum = map.get(curChar);

            if (i<s.length()-1 && curNum < map.get(s.charAt(i+1))) {
                sum -= curNum;
            } else {
                sum += curNum;
            }
        }

        return sum;
    }
}

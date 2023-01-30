package string;

public class ZigzagConv {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;

        String[] container = new String[numRows];
        // init container
        for (int i=0; i<container.length; i++) {
            container[i] = "";
        }

        int j = 0; // row
        boolean up = true;
        // assemble
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            container[j] += cur;

            if (j==0 || j==numRows - 1) { // up -> !up when i=0, j=0
                up = !up;
            }

            j += up ? -1 : 1; // if downward j++; if upward j--;

        }
        // print res
        String res = "";
        for (String c : container) res += c;

        return res;
    }
}

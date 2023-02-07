package string;

public class StudentAttendence {
    public static void main(String[] args) {
        String s = "PPAAAALL";
        System.out.println(checkRecord(s));
    }

    public static boolean checkRecord(String s) {
        // cal absent
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'A') cnt++;
            if (cnt >= 2) return false;
        }
        // cal late
        int max = 0; cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'L') {
                cnt++;
            } else {
                max = Math.max(cnt, max);
                cnt = 0;
            }
        }
        max = Math.max(cnt, max);

        return max >= 3 ? false : true;
    }
}

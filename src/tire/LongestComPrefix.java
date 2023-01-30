package tire;

public class LongestComPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * Horizontal scan
     * */
    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for (int i=1; i<strs.length; i++) {
            String cur = strs[i];
            int len = Math.min(cur.length(), ans.length());

            while (!cur.substring(0, len).equals(ans)) {
                ans = ans.substring(0, ans.length() - 1);
                len = Math.min(cur.length(), ans.length());
            }
        }

        return ans;
    }
}

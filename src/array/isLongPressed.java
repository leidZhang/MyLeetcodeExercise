package array;

public class isLongPressed {
    public static void main(String[] args) {
        String name = "alex";
        String typed = "aaleexa";
        System.out.println("\n" + isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        if (name.length() >= typed.length()) return name.equals(typed);

        int j = 0; // j for name
        for (int i=0; i<typed.length(); i++) {
            if (j < name.length() && name.charAt(j) == typed.charAt(i)) j++;
            else if (j == 0 || typed.charAt(i) != typed.charAt(i-1)) return false;
        }

        return j == name.length();
    }
}

package array;

public class ToLowerCase {
    public String toLowerCase(String s) {
        char[] arr = s.toCharArray(); // use toCharArray to change String

        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += ('a' - 'A');
            }
        }

        return new String(arr);
    }
}

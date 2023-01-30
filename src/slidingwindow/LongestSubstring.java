package slidingwindow;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * slide window
     * have to define the left bound and the right bound
     * we have to know the location of the last time it appears
     * so we need an array
     * */
    public static int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        int max = 0;

        for (int i=0; i<128; i++) {
            pos[i] = -1; // init map
        }

        int leftbound = 0;
        for (int rightbound=0; rightbound<s.length(); rightbound++) { // i as right bound
            char cur = s.charAt(rightbound); // the character

            // if the char occur again, update to the next position that it appears in the previous
            leftbound = Math.max(leftbound, pos[cur] + 1);
            max = Math.max(max, rightbound - leftbound + 1); // check the maximum

            pos[cur] = rightbound; // update the last position
        }

        return max;
    }
}

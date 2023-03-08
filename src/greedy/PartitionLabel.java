package greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        for (int i=0; i<s.length(); i++) {
            hash[s.charAt(i) - 'a'] = i; // a hash table to store the last position of the char
        }

        int left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            if (right == i) { // we get to the partition point
                res.add(right - left + 1);
                left = i + 1;
            }
        }

        return res;
    }
}

package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatDNASeq {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) return new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String seg = s.substring(0, 10);
        map.put(seg, 1);
        char[] seq = s.toCharArray();
        for (int i=10; i<seq.length; i++) {
            seg = seg.substring(1);
            seg += seq[i];
            map.put(seg, map.getOrDefault(seg, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }

        return res;
    }
}

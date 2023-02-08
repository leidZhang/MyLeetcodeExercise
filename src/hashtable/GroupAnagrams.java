package hashtable;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<strs.length; i++) {
            // sort string
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String cur = new String(temp);
            // put into map
            if (!map.containsKey(cur)) {
                List<String> container = new ArrayList<>();
                container.add(strs[i]);
                map.put(cur, container);
            } else {
                List<String> container = map.get(cur);
                container.add(strs[i]);
                map.put(cur, container);
            }
        }
        // get result from map
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(new ArrayList<>(entry.getValue()));
        }

        return res;
    }
}

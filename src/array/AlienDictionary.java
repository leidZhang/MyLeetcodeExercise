package array;

public class AlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];

        for (int i=0; i<order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i; // init orderMap
        }

        for (int j=1; j<words.length; j++) {
            String pre = words[j-1];
            String cur = words[j];
            int n = pre.length();
            int m = cur.length();
            int maxLen = Math.max(n, m);

            for (int i=0; i<maxLen; i++) {
                int preidx = (i < n) ? orderMap[pre.charAt(i) - 'a'] : -1;
                int curidx = (i < m) ? orderMap[cur.charAt(i) - 'a'] : -1;
                // if (preidx == curidx) continue;
                if (preidx < curidx) break;  // confirm sort
                if (preidx > curidx) return false; // not sorted
            }
        }

        return true;
    }
}

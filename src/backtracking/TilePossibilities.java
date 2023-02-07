package backtracking;

import java.util.HashSet;
import java.util.Set;

public class TilePossibilities {
    Set<String> res = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        boolean[] used = new boolean[tiles.length()];
        dfs(tiles, "", used);
        return res.size();
    }

    public void dfs(String tiles, String combine, boolean[] used) {
        if (combine.length() > 0) {
            res.add(combine);
        }
        if (combine.length() == tiles.length()) return;

        for (int i=0; i<tiles.length(); i++) {
            if (i > 0 && tiles.charAt(i) == tiles.charAt(i-1) && !used[i-1]) continue;
            if (used[i]) continue;

            combine += tiles.charAt(i); used[i] = true;
            dfs(tiles, combine, used); used[i] = false;
            combine = combine.substring(0, combine.length() - 1);

        }
    }
}

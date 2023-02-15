package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);
        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int startIndex) {
        if (visited.contains(startIndex)) return;

        visited.add(startIndex);
        for (Integer idx : rooms.get(startIndex)) {
            dfs(rooms, visited, idx);
        }
    }
}

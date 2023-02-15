package graph;

import java.util.ArrayList;
import java.util.List;

public class PathSourceToTgt {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        backtracking(graph, n, 0);
        return res;
    }

    public void backtracking(int[][] graph, int n, int startIndex) {
        path.add(startIndex);

        if (startIndex == n-1) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i=0; i<graph[startIndex].length; i++) {
            backtracking(graph, n, graph[startIndex][i]);
            path.remove(path.size() - 1);
        }
    }
}

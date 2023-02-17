package graph;

import java.util.*;

public class FindSafeStates {
    public static void main(String[] args) {
        int[][] graphs = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graphs));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] terminal = new boolean[n];

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            dfs(graph, i, visited, terminal);
        }

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (terminal[i]) res.add(i);
        }

        return res;
    }

    private static boolean dfs(int[][] graph, int cur, boolean[] visited, boolean[] terminal) {
        if (visited[cur]) return terminal[cur];

        visited[cur] = true;
        boolean isTerminal = true;
        for (int next : graph[cur]) {
            isTerminal = isTerminal & dfs(graph, next, visited, terminal);
        }

        terminal[cur] = isTerminal;
        return terminal[cur];
    }
}

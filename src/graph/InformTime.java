package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InformTime {
    public static void main(String[] args) {
        int n = 6;
        int headID = 2;
        int[] manager = {2,2,-1,2,2,2};
        int[] informTIme = {0,0,1,0,0,0};

        System.out.println(numOfMinutesDFS(n, headID, manager, informTIme));
    }

    static int res = 0;
    static List<List<Integer>> subs = new ArrayList<>();

    public static int numOfMinutesDFS(int n, int headID, int[] manager, int[] informTime) {

        for (int i=0; i<n; i++) {
            subs.add(new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            if (manager[i] == -1) continue;
            subs.get(manager[i]).add(i);
        }

        dfs(manager, informTime, headID, informTime[headID]);

        return res;
    }

    private static void dfs(int[] manager, int[] informTime, int id, int time) {
        if (informTime[id] == 0) {
            res = Math.max(res, time);
            return;
        }

        for (int i=0; i<subs.get(id).size(); i++) {
            int subid = subs.get(id).get(i);
            time += informTime[subid];
            dfs(manager, informTime, subid, time);
            time -= informTime[subid];
        }
    }

    public static int numOfMinutesBFS(int n, int headID, int[] manager, int[] informTime) {
        // bulid map
        List<List<Integer>> employees = new ArrayList<>(n);
        for (int i=0; i<n; i++) {
            employees.add(new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            if (manager[i] != -1) {
                employees.get(manager[i]).add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>(); // init q
        q.add(new int[]{headID, informTime[headID]}); // start from boss

        int res = 0;
        while (!q.isEmpty()) { // bfs, but I personally think dfs is better
            int size = q.size();
            while (size != 0) {
                int[] cur = q.poll();
                res = Math.max(res, cur[1]); // we have to consider the total time from root to leaf
                for (int next : employees.get(cur[0])) {
                    q.add(new int[]{next, informTime[next] + cur[1]}); // add "child" time
                }
                size--;
            }
        }

        return res;
    }
}

package graph;

public class ProvinceNum {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];

        int cnt = 0;
        for (int i=0; i< isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                cnt++;
            }
        }

        return cnt;
    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited) {
        if(visited[i]) return;

        visited[i] = true;
        for (int j=0; j<isConnected[i].length; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }
}

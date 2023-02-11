package array;

public class SmallestManhattanDist {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, n = points.length, minDist = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            if (x == points[i][0] && Math.abs(points[i][1] - y) < minDist) {
                minDist = Math.abs(points[i][1] - y);
                res = i;
            }
            if (y == points[i][1] && Math.abs(points[i][0] - x) < minDist) {
                minDist = Math.abs(points[i][0] - x);
                res = i;
            }
        }

        return res;
    }
}

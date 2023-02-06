package math;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}}; int k = 1;
        int[][] res = kClosest(points, k);

        for (int i=0; i<res.length; i++) {
            for (int j=0; j<2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    static Comparator<int[]> cmp = new Comparator<int[]>() {
        public int compare(int[] e1, int[] e2) { // here asc
            int dist1 = e1[0] * e1[0] + e1[1] * e1[1];
            int dist2 = e2[0] * e2[0] + e2[1] * e2[1];
            return dist1 - dist2;
        }
    };

    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>(cmp);
        int[][] res = new int[k][2];

        for (int i=0; i<points.length; i++) {
            pq.add(points[i]);
        }
        for (int i=0; i<k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}

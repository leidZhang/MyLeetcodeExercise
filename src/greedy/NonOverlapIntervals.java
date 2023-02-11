package greedy;

import java.util.Arrays;

public class NonOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->{
            return o1[0] - o2[0];
        });

        int cnt = 0;
        for (int i=1; i<intervals.length; i++) {
            if (intervals[i-1][1] > intervals[i][0]) {
                intervals[i][1] = Math.min(intervals[i-1][1], intervals[i][1]);
                cnt++;
            }
        }

        return cnt;
    }
}

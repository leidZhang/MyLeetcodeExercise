package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /*
    * interval:    ____  ____  __   _____  ___
    * newInterval:         ___________
    *                    |               |
    *                   left<---mid--->right
    * */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // left interval
        int n = intervals.length, i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        // mid interval
        if (i < n) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
            }
        }
        res.add(newInterval);
        // right interval
        while (i < n) {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}

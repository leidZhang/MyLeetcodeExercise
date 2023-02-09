package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2)->{ // sort 2d array
            return o1[0] - o2[0];
        });

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            int prevHead = intervals[i-1][0];
            int prevTail = intervals[i-1][1];
            int curHead = intervals[i][0];
            int curTail = intervals[i][1];

            if (curHead > prevTail) { // no intersection
                res.add(intervals[i]);
            } else {
                int newHead = Math.min(prevHead, curHead);
                int newTail = Math.max(prevTail, curTail);
                res.remove(intervals[i-1]); // replace the old interval
                intervals[i] = new int[]{newHead, newTail};
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[0][]);
    }
}

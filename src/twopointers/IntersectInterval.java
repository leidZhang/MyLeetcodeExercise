package twopointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectInterval {
    public static void main(String[] args) {
        int[][] firstList = {{3,5},{9,20}};
        int[][] secondList = {{4,5},{7,10},{11,12},{14,15},{16,20}};
        int[][] res = intervalIntersection(firstList, secondList);

        for (int[] intersect : res) {
            System.out.println(intersect[0] + "," + intersect[1]);
        }
    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;

        int idxa = 0, idxb = 0;
        List<int[]> res = new ArrayList<>();
        while (idxa < n && idxb < m) {
            if (firstList[idxa][0] < secondList[idxb][1] || secondList[idxb][0] < firstList[idxa][1]) {
                int lower = Math.max(firstList[idxa][0], secondList[idxb][0]);
                int upper = Math.min(firstList[idxa][1], secondList[idxb][1]);
                if (lower <= upper) res.add(new int[]{lower, upper});
            }

            if (firstList[idxa][1] < secondList[idxb][1]) {
                idxa++;
            } else {
                idxb++;
            }
        }

        return res.toArray(new int[0][0]);
    }
}

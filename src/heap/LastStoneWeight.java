package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {2,2};
        System.out.println(lastStoneWeight(stones));
    }

    static Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // desc
        }
    };

    public static int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(cmp);

        int n = stones.length;
        for (int i=0; i<n; i++) {
            heap.add(stones[i]);
        }

        while (heap.size() != 0 && heap.size() != 1) { // also tackle edge cases
            int x = heap.poll();
            int y = heap.poll();
            if (x - y != 0) {
                heap.add(x-y);
            }
        }

        return (!heap.isEmpty()) ? heap.poll() : 0;
    }
}

package stack_and_queue;

import java.util.*;

public class TopKFreq {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3}; int k = 2;
        int[] ans = topKFrequent(nums, k);

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    static Comparator<int[]> cmp = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) { // compare int[] a and int[] b
            return a[1] - b[1]; // asc, b[1] - a[1] for desc
        }
    };

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> heap = new PriorityQueue<>(cmp);

        for (int i=0; i<nums.length; i++) { // add to map
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (heap.size() < k) { // size < k, we can add new elements
                heap.add(new int[]{entry.getKey(), entry.getValue()});
            } else { // size > k, we have to pop out an element
                if (entry.getValue() > heap.peek()[1]) {
                    heap.poll();
                    heap.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i=k-1; i>=0; i--) {
            res[i] = heap.poll()[0]; // pop the smallest and add to the tail
        }
        return res;
    }
}

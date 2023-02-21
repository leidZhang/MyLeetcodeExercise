package heap;

import java.util.*;

public class TopKFreqStr {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    static Comparator<Map.Entry<String, Integer>> cmp = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if (o2.getValue() == o1.getValue()) {
                return o1.getKey().compareTo(o2.getKey()); // asc lexico order
            }
            return o2.getValue() - o1.getValue(); // desc num order
        }
    };

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Queue<Map.Entry<String, Integer>> heap = new PriorityQueue<>(cmp);

        for (int i=0; i< words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }

        List<String> res = new ArrayList<>(); // how to sort it?
        for (int i=0; i<k; i++) {
            res.add(heap.poll().getKey());
        }

        return res;
    }
}

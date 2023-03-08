package heap;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    static Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o2[1] == o1[1]) {
                return o1[0] - o2[0]; // if frequency is same, choose the id with smaller ascii
            }
            return o2[1] - o1[1]; // desc order for frequency
        }
    };

    public static int leastInterval(char[] tasks, int n) {
        StringBuilder schedule = new StringBuilder(); // for debug
        Queue<int[]> heap = new PriorityQueue<>(cmp);
        int[] freq = new int[26]; // store frequency
        for (int i=0; i<tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        for (int i=0; i<26; i++) {
            if (freq[i] == 0) continue;
            heap.add(new int[]{i, freq[i]}); // [id, frequency]
        }

        int cnt = 0; // counter
        while (!heap.isEmpty()) {
            List<int[]> taskList = new ArrayList<>(); // for example, A -> B -> C | A -> D -> idle | ...
            int cycle = n + 1;
            while (cycle > 0 && !heap.isEmpty()) { // assign task
                int[] task = heap.poll(); // [id, frequency]
                schedule.append((char)(task[0] + 'A')).append("->"); // print tasks
                taskList.add(new int[]{task[0], task[1] - 1});
                cnt++; cycle--;
            }

            for (int[] t : taskList) if (t[1] > 0) heap.add(t);
            if (!heap.isEmpty()) {
                cnt += cycle; // idles
                while (cycle-- != 0) {
                    schedule.append("idle->"); // print idle
                }
            }
        }

        System.out.println(schedule.substring(0, schedule.length() - 2)); // delete the last "->"
        return cnt;
    }
}

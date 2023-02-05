package stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5}; int k = 3;
        int[] res = maxSlidingWindow(nums, k);

        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int j = 0;
        int[] res = new int[nums.length - k + 1];
        MonoQueue mq = new MonoQueue();

        for (int i=0; i<k-1; i++) { // init mq
            mq.add(nums[i]);
        }

        for (int i=0; i<nums.length - k + 1; i++) { // i is the position of the first element of the window
            mq.add(nums[i+k-1]); // now k elements are in the virtual sliding window
            res[j++] = mq.getMax(); // add max to res

            if (nums[i] == mq.getMax()) {
                mq.poll(nums[i]);
            }
        }

        return res;
    }

    static class MonoQueue {
        Deque<Integer> dq = new LinkedList<>();

        public int getMax() {
            return dq.peek();
        }

        public void add(int val) { // max value is always at front
            while (!dq.isEmpty() && val > dq.getLast()) { // make sure that second large value is at second
                dq.removeLast();
            }
            dq.add(val);
        }

        public void poll(int val) {
            if (!dq.isEmpty() && val == dq.peek()) { // poll largest
                dq.poll();
            }
        }
    }
}

package stack_and_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(); // val, next greater
        Stack<Integer> st = new Stack<>();

        for (int i=m-1; i>=0; i--) {
            while (!st.isEmpty() && nums2[i] >= st.peek()) {
                st.pop();
            }
            if (st.size() > 0) { // st.peek is the greater element
                map.put(nums2[i], st.peek());
            } else { // no greater element
                map.put(nums2[i], -1);
            }
            st.push(nums2[i]);
        }

        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

package stack_and_queue;

import java.util.Stack;

public class PalinLinkedListST {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // corner cases

        Stack<Integer> st = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            st.push(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            int i = st.pop();
            if (i != head.val) return false;
            head = head.next;
        }

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
            // default constructor
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}

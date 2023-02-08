package linkedlist;

public class RevLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head; // edge cases

        ListNode prev = head;
        ListNode cur = prev.next;
        ListNode next = cur.next;
        prev.next = null;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        return cur;
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

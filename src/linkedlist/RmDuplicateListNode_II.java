package linkedlist;

public class RmDuplicateListNode_II {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;
        ListNode next = cur.next;

        while (next != null) {
            if (cur.val == next.val) {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                pre.next = next;
                cur = next;
                if (cur == null) break;
                next = next.next;
            } else {
                cur = cur.next;
                next = next.next;
                pre = pre.next;
            }
        }

        return dummy.next;
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
